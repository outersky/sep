package cn.hillwind.sep;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 */
public interface ColumnRenderer {

    void initWorkbook(Workbook wb);
    void initSheet(Workbook wb, Sheet sheet);

    /**
     * 填充Cell
     *
     * @param rendererOptions render配置
     * @param wb              cell所属Workbook
     * @param sheet           cell所属Sheet
     * @param row             cell所属Row
     * @param cell            当前Cell
     * @param columnDesc      本列的Desc
     * @param value           数据内容，约等于 obj[propName]。 如果需要参考其它属性，可以访问下面的obj或propName参数。
     * @param obj             数据对象
     * @param propName        数据属性。可以是下标或者级联属性,如 books[1], books[1].author.name 等。
     * @param dataRowIndex    本条数据对象在数据List中的行号.
     */
    void render(String rendererOptions, Workbook wb, Sheet sheet, Row row, Cell cell, ColumnDesc columnDesc, Object value, Object obj, String propName, int dataRowIndex);
}
