package cn.hillwind.sep;

import junit.framework.TestCase;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 */
public class MainTest extends TestCase {

    public static void main(String[] args) throws Exception{
        new MainTest().test();
    }

    @Test
    public void test() throws Exception{
        // 需要修改为本地绝对路径, 如：c:/workspace/chuanshu.xlsx
        String excelFile  = "/Volumes/src/git/sep/src/test/resources/chuanshu.xlsx";
        String configFile = "/Volumes/src/git/sep/src/test/resources/chuanshu.json";

        File file = new File(excelFile);

        //以只读方式打开Excel文件
        OPCPackage p = OPCPackage.open(file, PackageAccess.READ);
        ExcelReader excelReader = new ExcelReader(p);

        //读取Excel列与Java对象属性对应的配置文件
        ExcelDescFile excelDescFile = ExcelDescFile.create(new FileInputStream(configFile));

        ExcelRowHandler<ChuanShuTJBExport> rowHandler = new ExcelRowHandler<ChuanShuTJBExport>(excelDescFile, ChuanShuTJBExport.class);

        //目前只读取“明细”中的内容
        excelReader.handlers.put("明细", rowHandler);

        excelReader.process();

        ChuanShuTJBExport export = rowHandler.getResult().get(0);
        assertEquals(464, rowHandler.getResult().size());
    }



}
