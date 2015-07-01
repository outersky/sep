package cn.hillwind.sep;

import java.util.List;

/**
 *
 */
public interface RowHandler<T> {
    void process(String sheetName, Row row) ;
    List<T> getResult();
}
