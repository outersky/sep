package cn.hillwind.sep;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 *
 */
public class ExcelWriter {

    ExcelDescFile excelDescFile;
    InputStream templateStream;
    File targetXlsxFile;
    SXSSFWorkbook workbook;

    /**
     *
     * @param excelDescFile  json格式的Excel描述符
     * @param templateStream xlsx格式的模板文件。需要将空行都删除，ExcelWriter只从最后添加行。
     * @param targetXlsxFile 保存目标文件
     * @param compressTmpFiles 是否压缩临时文件。 不压缩可能会导致临时文件很大，压缩会略微降低速度
     * @param useSharedStringsTable Excel是否使用共享的字符串表，使用会减小文件大小，不使用会提升速度
     * @throws IOException
     */
    public ExcelWriter(ExcelDescFile excelDescFile, InputStream templateStream, File targetXlsxFile,boolean compressTmpFiles, boolean useSharedStringsTable) throws IOException {
        this.excelDescFile = excelDescFile;
        this.templateStream = templateStream;
        this.targetXlsxFile = targetXlsxFile;

        workbook = new SXSSFWorkbook(
                new XSSFWorkbook(templateStream),
                100,
                compressTmpFiles,
                useSharedStringsTable); // keep 100 rows in memory, exceeding rows will be flushed to disk

        excelDescFile.getOption().getColumnRenderer().initWorkbook(workbook);

    }

    public ExcelWriter(ExcelDescFile excelDescFile, String templateResource, File targetXlsxFile) throws IOException {
        this(excelDescFile,ExcelWriter.class.getResourceAsStream(templateResource),targetXlsxFile);
    }
    public ExcelWriter(ExcelDescFile excelDescFile, InputStream templateStream, File targetXlsxFile) throws IOException {
        this(excelDescFile, templateStream, targetXlsxFile, true, false);
    }

    public void save() throws IOException {
        FileOutputStream out = new FileOutputStream(targetXlsxFile);
        workbook.write(new BufferedOutputStream(out));
        out.close();
        workbook.dispose();
    }

    public <T> void write(String sheetName, List<T> list ) {

        try {
            Sheet sheet = workbook.getSheet(sheetName);

            SheetDesc sheetDesc = excelDescFile.getSheetDesc(sheetName);

            excelDescFile.getOption().getColumnRenderer().initSheet(workbook,sheet);

            sheetDesc.write(workbook, sheet, list);

        }catch(Exception exp){
            throw new RuntimeException(exp);
        }
    }

    public static <T> void write(ExcelDescFile excelDescFile, InputStream templateStream, File targetXlsxFile, String sheetName, List<T> list ) {
        try {
            SXSSFWorkbook wb = new SXSSFWorkbook(
                    new XSSFWorkbook(templateStream),
                    100,
                    true); // keep 100 rows in memory, exceeding rows will be flushed to disk
            Sheet sheet = wb.getSheet(sheetName);

            CellStyle cellStyle = wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("yyyy/MM/dd"));

            excelDescFile.getOption().getColumnRenderer().initWorkbook(wb);

            SheetDesc sheetDesc = excelDescFile.getSheetDesc(sheetName);

            excelDescFile.getOption().getColumnRenderer().initSheet(wb,sheet);
            sheetDesc.write(wb, sheet, list);

            FileOutputStream out = new FileOutputStream(targetXlsxFile);
            wb.write(new BufferedOutputStream(out));
            out.close();
            wb.dispose();

        }catch(Exception exp){
            throw new RuntimeException(exp);
        }
    }

}