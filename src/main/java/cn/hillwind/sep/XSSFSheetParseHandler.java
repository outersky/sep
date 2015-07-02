package cn.hillwind.sep;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Derived from http://poi.apache.org/spreadsheet/how-to.html#xssf_sax_api
 * <p/>
 * Also see Standard ECMA-376, 1st edition, part 4, pages 1928ff, at
 * http://www.ecma-international.org/publications/standards/Ecma-376.htm
 * <p/>
 * A web-friendly version is http://openiso.org/Ecma/376/Part4
 */
class XSSFSheetParseHandler extends DefaultHandler {

    /**
     * Table with styles
     */
    private StylesTable stylesTable;

    /**
     * Table with unique strings
     */
    private ReadOnlySharedStringsTable sharedStringsTable;

    // Set when V start element is seen
    private boolean vIsOpen;

    private boolean hasValue;

    // Set when cell start element is seen;
    // used when cell close element is seen.
    private Cell.ValueType nextDataType;

    // Used to format numeric cell values.
    private short formatIndex;
    private String formatString;
    private final DataFormatter formatter;

    // Gathers characters as they are seen.
    private StringBuilder value;

    private Row row = null; // 当前行
    private Cell cell = null; // 当前格

    private RowHandler rowHandler;

    private String currentSheetName;

    /**
     * Accepts objects needed while parsing.
     *
     * @param styles  Table of styles
     * @param strings Table of shared strings
     */
    public XSSFSheetParseHandler(
            StylesTable styles,
            ReadOnlySharedStringsTable strings,
            RowHandler rowHandler) {
        this.stylesTable = styles;
        this.sharedStringsTable = strings;
        this.rowHandler = rowHandler;
        this.value = new StringBuilder();
        this.nextDataType = Cell.ValueType.NUMBER;
        this.formatter = new DataFormatter();
    }

    /*
       * (non-Javadoc)
       * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
       */
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {

        if ("row".equals(name)) {
            this.row = new Row();
            row.index = attributes.getValue("r");

        } else if ("inlineStr".equals(name) || "v".equals(name) || "t".equals(name)) {
            vIsOpen = true;
            hasValue = true;
            // Clear contents cache
            value.setLength(0);
        }
        // c => cell
        else if ("c".equals(name)) {
            this.cell = new Cell();
            hasValue = false; // clear hasValue flag
            // Get the cell reference
            cell.ref = attributes.getValue("r");
/*
            int firstDigit = -1;
            for (int c = 0; c < r.length(); ++c) {
                if (Character.isDigit(r.charAt(c))) {
                    firstDigit = c;
                    break;
                }
            }

            thisColumn = nameToColumn(r.substring(0, firstDigit));
*/

            // Set up defaults.
            this.nextDataType = Cell.ValueType.NUMBER;
            this.formatIndex = -1;
            this.formatString = null;
            String cellType = attributes.getValue("t");
            String cellStyleStr = attributes.getValue("s");
            if ("b".equals(cellType))
                nextDataType = Cell.ValueType.BOOL;
            else if ("e".equals(cellType))
                nextDataType = Cell.ValueType.ERROR;
            else if ("inlineStr".equals(cellType))
                nextDataType = Cell.ValueType.INLINESTR;
            else if ("s".equals(cellType))
                nextDataType = Cell.ValueType.SSTINDEX;
            else if ("str".equals(cellType))
                nextDataType = Cell.ValueType.FORMULA;
            else if (cellStyleStr != null) {
                // It's a number, but almost certainly one
                //  with a special style or format
/*
                int styleIndex = Integer.parseInt(cellStyleStr);
                XSSFCellStyle style = stylesTable.getStyleAt(styleIndex);
                this.formatIndex = style.getDataFormat();
                this.formatString = style.getDataFormatString();
                if (this.formatString == null)
                    this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
*/
            }
        }

    }

    /*
       * (non-Javadoc)
       * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
       */
    public void endElement(String uri, String localName, String name)
            throws SAXException {

        String valueString;

        // inlineStr 暂未实现，数据表示法: <c r="B2" t="inlineStr"><is><t>&#20256;&#36755;14-203-006</t></is></c>

        // v => contents of a cell
        if ("v".equals(name)) {
            // Process the value contents as required.
            // Do now, as characters() may be called more than once
            switch (nextDataType) {

                case BOOL:
                    char first = value.charAt(0);
                    valueString = first == '0' ? "0" : "1"; // 0: FALSE, 1: TRUE
                    break;

                case ERROR:
                    valueString = "ERROR:" + value.toString();
                    break;

                case FORMULA:
                    // A formula could result in a string value,
                    // so always add double-quote characters.
                    valueString = value.toString();
                    break;

                case INLINESTR:
                    // TODO: have seen an example of this, so it's untested.
                    XSSFRichTextString rtsi = new XSSFRichTextString(value.toString());
                    valueString = rtsi.toString();
                    break;

                case SSTINDEX:
                    String sstIndex = value.toString();
                    try {
                        int idx = Integer.parseInt(sstIndex);
                        XSSFRichTextString rtss = new XSSFRichTextString(sharedStringsTable.getEntryAt(idx));
                        valueString = rtss.toString();
                    }
                    catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        throw new RuntimeException("Failed to parse SST index '" + sstIndex + "': " + ex.toString());
                    }
                    break;

                case NUMBER:
                    String n = value.toString();
                    if (this.formatString != null)
                        // valueString = formatter.formatRawCellContents(Double.parseDouble(n), this.formatIndex, this.formatString);
                        valueString = n;
                    else
                        valueString = n;
                    break;

                default:
                    valueString = "(TODO: Unexpected type: " + nextDataType + ")";
                    break;
            }

            cell.type = nextDataType;
            cell.value = valueString;
            row.add(cell);

        } else if ("t".equals(name)) {
            valueString = value.toString();
            cell.type = nextDataType;
            cell.value = valueString;
            row.add(cell);
        } else if ("row".equals(name)) {
            rowHandler.process(getCurrentSheetName() ,row);
        }

        if ("inlineStr".equals(name) || "v".equals(name) || "t".equals(name)){
            vIsOpen = false;
        }

    }

    /**
     * Captures characters only if a suitable element is open.
     * Originally was just "v"; extended for inlineStr also.
     */
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (vIsOpen)
            value.append(ch, start, length);
    }

    public String getCurrentSheetName() {
        return currentSheetName;
    }

    public void setCurrentSheetName(String currentSheetName) {
        this.currentSheetName = currentSheetName;
    }
}
