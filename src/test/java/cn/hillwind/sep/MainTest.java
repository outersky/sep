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

    @Test
//    public static void main(String[] args) throws Exception{
    public void test() throws Exception{
        File file = new File("/Volumes/src/git/sep/src/test/resources/chuanshu.xlsx");
        OPCPackage p = OPCPackage.open(file, PackageAccess.READ);
        //PrintStream ps = new PrintStream(new BufferedOutputStream( new FileOutputStream("/tmp/zs.csv") ) );
        ExcelReader excelReader = new ExcelReader(p);
        ExcelDescFile excelDescFile = ExcelDescFile.create(new FileInputStream("/Volumes/src/hg/psp/src/main/resources/chuanshu_init.json"));
        excelDescFile.getOption().setMaxErrorCount(Integer.MAX_VALUE);
        excelDescFile.getOption().setColumnValidator(new DefaultRegexColumnValidator());
        ExcelRowHandler<ChuanShuTJB> rowHandler = new ExcelRowHandler<ChuanShuTJB>(excelDescFile, ChuanShuTJB.class);
        excelReader.handlers.put("明细", rowHandler);
        excelReader.process();

        assertEquals(2,rowHandler.getResult().size());
    }

}
