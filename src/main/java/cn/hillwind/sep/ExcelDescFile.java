package cn.hillwind.sep;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Excel描述文件
 * 用来表示一个Excel的格式
 * 可以区分导入、导出；
 * 可以在读取时限定字段的内容；
 * 可以设定输出格式.
 *
 */
public class ExcelDescFile {
    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件格式描述
     */
    private String description;

    /**
     * SheetDesc, 描述有多个Sheet的Excel文件模板时使用
     */
    private SheetDesc[] sheets;

    private Option option = new Option();

    public static ExcelDescFile create(String configFileResource){
        return create(ExcelDescFile.class.getResourceAsStream(configFileResource));
    }

    public static ExcelDescFile create(InputStream configFile){
        Gson gson = new Gson();
        ExcelDescFile excelDescFile = gson.fromJson(new InputStreamReader(configFile), ExcelDescFile.class);
        for(SheetDesc sheetDesc : excelDescFile.getSheets()){
            sheetDesc.setExcelDescFile(excelDescFile);
        }
        return excelDescFile;
    }

    public SheetDesc getSheetDesc(String sheetName){
        if(sheets==null || sheets.length==0) return null;
        for(SheetDesc sh : sheets){
            if(sh.getName().equals(sheetName)){
                return sh;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SheetDesc[] getSheets() {
        return sheets;
    }

    public void setSheets(SheetDesc[] sheets) {
        this.sheets = sheets;
    }

    public Option getOption() {
        return option;
    }

}

