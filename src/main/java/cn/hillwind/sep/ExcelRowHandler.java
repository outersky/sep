package cn.hillwind.sep;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ExcelRowHandler<T> implements RowHandler<T> {

    private ExcelDescFile excelDescFile;
    private Class<T> clz;

    private List<T> list = new ArrayList<T>();

    public ExcelRowHandler(ExcelDescFile excelDescFile, Class<T> clz){
        this.excelDescFile = excelDescFile;
        this.clz = clz;
    }

    @Override
    public void process(String sheetName, Row row) {
        // 跳过空行
        if ( row.cells.isEmpty() ) {
            return;
        }
        SheetDesc sheetDesc = excelDescFile.getSheetDesc(sheetName);
        T bean = sheetDesc.readRow(row, clz);
        if(bean!=null) list.add(bean);
    }

    public List<T> getResult(){
        return list;
    }

}
