package cn.hillwind.sep;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Excel Sheet 描述
 */
public class SheetDesc {

    private ExcelDescFile excelDescFile;
    String name ;

    /**
     * 标题的行数，读写时需要跳过
     */
    int headerRows;

    /**
     * ColumnDesc, 描述Sheet中的每一列
     */
    ColumnDesc[] columns;

    public SheetDesc() {
    }

    public void write(Workbook wb, Sheet sheet, List sheetData) {
        if(columns==null || columns.length==0 || sheetData==null || sheetData.isEmpty()){
            return;
        }

        int rowIndex = sheet.getPhysicalNumberOfRows() + 1;
        for (Object obj : sheetData) {
            // Create a row and put some cells in it. Rows are 0 based.
            //跳过表头！！！！
            org.apache.poi.ss.usermodel.Row row = sheet.createRow( rowIndex);
            //row.setRowStyle(style);
            for (ColumnDesc columnDesc : columns) {
                try {
                    // 如果本列没有查看权限，跳过
                    if(!columnDesc.canRead(excelDescFile.getOption().getRoles())){
                        continue;
                    }

                    Object value = StringUtil.isEmpty(columnDesc.name) ? null : PropertyUtils.getProperty(obj, columnDesc.name);  // BeanUtils.getProperty(obj, name);

                    org.apache.poi.ss.usermodel.Cell cel = row.createCell(columnDesc.columnIndex);

                    ColumnRenderer cr = excelDescFile.getOption().getColumnRenderer();
                    cr.render(columnDesc.rendererOptions, wb, sheet, row, cel, columnDesc, value, obj, columnDesc.name, rowIndex);
                }catch(Exception exp){
                    exp.printStackTrace();
                }
            }
            rowIndex ++;
        }
    }

    protected boolean isEmptyRow(Row row) {
        for (ColumnDesc columnDesc : columns) {
            if(columnDesc.isKey()){
                Cell cell = row.find(columnDesc.getColumn());
                if(cell==null) return true;
                String value = cell.value;
                if(value==null || StringUtil.isEmpty(value) ){
                    return true;
                }
            }
        }
        return false;
    }

    public <T> T readRow(Row row, Class<T> clz) {
        if(isEmptyRow(row)){
            return null;
        }
        // 跳过标题行
        if(Integer.parseInt(row.index) <= getHeaderRows()){
            return null;
        }

        T obj = null;
        try {
            obj = clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (ColumnDesc columnDesc : columns) {
            // 无名列，自动忽略
            if(StringUtil.isEmpty(columnDesc.getName())){
                continue;
            }
            // 如果本列没有更新数据库的权限，跳过
            if(!columnDesc.canModify(excelDescFile.getOption().getRoles())){
                continue;
            }
            Cell cell = row.find(columnDesc.getColumn());
            String value = cell == null ? null : cell.value; // null if cell==null

            //如果格子是空的
            if( value==null || StringUtil.isEmpty(value) ) {
                // 如果不允许为空，报错
                if(!columnDesc.isAllowBlank()) {
                    excelDescFile.getOption().addError("[" + columnDesc.getColumn() + row.index + "]错误 : 不能为空");
                }
                continue;
            }
            // 格子有值，校验成功后，设置为有关属性
            if(validateCell(columnDesc, cell)) {
                if(columnDesc.getDataFormat()== ColumnDataFormat.date){
                    if(cell.type != Cell.ValueType.NUMBER) {
                        excelDescFile.getOption().addError("[" + cell.ref + "]错误 : 必须为日期格式");
                    }else {
                        try {
                            BeanUtils.setProperty(obj, columnDesc.getName(), DateUtil.getJavaDate(Double.parseDouble(value)).getTime());
                        } catch (Exception e) {
                            excelDescFile.getOption().addError("[" + cell.ref + "] 设置错误 : " + e.getMessage());
                        }
                    }
                }else{
                    try {
                        BeanUtils.setProperty(obj, columnDesc.getName(), value);
                    } catch (Exception e) {
                        excelDescFile.getOption().addError("[" + cell.ref + "] 设置错误 : " + e.getMessage());
                    }
                }
            }
        }
        return obj;
    }

    /**
     * 将source中，有修改权限的字段，全部复制到target对象中。
     * @param source
     * @param target
     * @param roles
     * @param <T>
     */
    public <T> void modify(T source, T target, String[] roles) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for (ColumnDesc columnDesc : columns) {
            // 无名列，自动忽略
            if(StringUtil.isEmpty(columnDesc.getName())){
                continue;
            }
            if(columnDesc.canModify(roles)){
                BeanUtils.setProperty(target, columnDesc.getName(), BeanUtils.getProperty(source, columnDesc.getName()));
            }
        }
    }

    /**
     * 校验对象是否有效
     * @return true: 有效; false: 校验失败。失败错误内容会存储到Option.ErrorContext
     */
    protected boolean validateCell(ColumnDesc columnDesc, Cell cell) throws ParseErrorListException {
        ColumnValidator v = excelDescFile.getOption().getColumnValidator();
        if(v==null){
            return true;
        }
        String errorMsg = v.validate(columnDesc,cell);
        if(errorMsg!=null){
            excelDescFile.getOption().addError("第 " +  cell.ref + " 个格子： " + columnDesc.getTitle()+ " 错误: " + errorMsg);
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeaderRows() {
        return headerRows;
    }

    public void setHeaderRows(int headerRows) {
        this.headerRows = headerRows;
    }

    public ColumnDesc[] getColumns() {
        return columns;
    }

    public void setColumns(ColumnDesc[] columns) {
        this.columns = columns;
    }

    public ExcelDescFile getExcelDescFile() {
        return excelDescFile;
    }

    public void setExcelDescFile(ExcelDescFile excelDescFile) {
        this.excelDescFile = excelDescFile;
    }
}
