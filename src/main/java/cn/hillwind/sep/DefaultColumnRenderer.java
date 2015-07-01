package cn.hillwind.sep;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

/**
 * 默认输出
 * 日期：均假设为Long类型的日期，如果值为0，则不输出；日期格式需要事先在Excel模板中设置好。
 * 数值：会设置单元格为数值类型
 * 其他：作为文本内容输出
 */
public class DefaultColumnRenderer implements ColumnRenderer {

    CellStyle dateCellStyle ;

    @Override
    public void initWorkbook(Workbook wb){
        dateCellStyle = wb.createCellStyle();
        DataFormat dataFormat = wb.createDataFormat();
        dateCellStyle.setDataFormat(dataFormat.getFormat("yyyy/m/d"));
    }

    @Override
    public void initSheet(Workbook wb, Sheet sheet){
    }

    @Override
    public void render(String rendererOptions,
                       Workbook wb,
                       Sheet sheet,
                       Row row,
                       Cell cell,
                       ColumnDesc columnDesc,
                       Object value,
                       Object obj,
                       String propName,
                       int dataRowIndex) {
        if(value==null) return;

        switch (columnDesc.getDataFormat()){
            case date:
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);

                if( value instanceof Long){
                    if( (Long)value == 0L ){
                        break;
                    }
                    cell.setCellValue(new Date( (Long)value ));
                }else if(value instanceof Date){
                    cell.setCellValue((Date)value);
                }

                cell.setCellStyle(dateCellStyle);
                break;

            case number:
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Double.valueOf(value.toString()));
                break;

            default:
                CreationHelper createHelper = wb.getCreationHelper();
                cell.setCellValue(createHelper.createRichTextString(value.toString()));
                break;
        }
    }
}
