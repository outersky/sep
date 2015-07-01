package cn.hillwind.sep;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从poi的例子 XLSX2CSV 修改而来
 */
public class ExcelReader {

    Map<String,RowHandler> handlers = new HashMap<String, RowHandler>();

    ///////////////////////////////////////

    private OPCPackage xlsxPackage;

    /**
     * Creates a new XLSX -> CSV converter
     *
     * @param pkg        The XLSX package to process
     */
    public ExcelReader(OPCPackage pkg) {
        this.xlsxPackage = pkg;
    }

    /**
     * Parses and shows the content of one sheet
     * using the specified styles and shared-strings tables.
     *
     * @param styles
     * @param strings
     * @param sheetInputStream
     */
    public void processSheet(
            String sheetName,
            StylesTable styles,
            ReadOnlySharedStringsTable strings,
            InputStream sheetInputStream,
            RowHandler rowHandler)
            throws IOException, ParserConfigurationException, SAXException {

        InputSource sheetSource = new InputSource(sheetInputStream);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        XMLReader sheetParser = saxParser.getXMLReader();
        XSSFSheetParseHandler handler = new XSSFSheetParseHandler(styles, strings, rowHandler);
        handler.setCurrentSheetName(sheetName);
        sheetParser.setContentHandler(handler);
        sheetParser.parse(sheetSource);
    }

    /**
     * Initiates the processing of the XLS workbook file to CSV.
     *
     * @throws IOException
     * @throws OpenXML4JException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public void process()
            throws IOException, OpenXML4JException, ParserConfigurationException, SAXException {

        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
        XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
        StylesTable styles = xssfReader.getStylesTable();
        XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        while (iter.hasNext()) {
            InputStream stream = iter.next();
            try {
                String sheetName = iter.getSheetName();
                RowHandler handler = handlers.get(sheetName);
                if (handler == null) {
                    continue;
                }
                processSheet(sheetName, styles, strings, stream, handler);
            }finally {
                stream.close();
            }
        }
    }

    public static <T> List<T> read(ExcelDescFile excelDescFile, File xlsxFile, String sheetName, Class<T> clz) {
        OPCPackage p;
        try {
            p = OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        ExcelReader excelReader = new ExcelReader(p);
        excelDescFile.getOption().setMaxErrorCount(Integer.MAX_VALUE);
        ExcelRowHandler<T> rowHandler = new ExcelRowHandler<T>(excelDescFile, clz);
        excelReader.handlers.put(sheetName, rowHandler);

        try {
            excelReader.process();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OpenXML4JException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        return rowHandler.getResult();
    }

}