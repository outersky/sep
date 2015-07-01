package cn.hillwind.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * sax方式的excel解析中，没有Row的概念，所以需要自定义一个,方便程序处理.
 */
public class Row {

    String index; // 行号 1-based
    List<Cell> cells = new ArrayList<Cell>();

    public void add(Cell cell) {
        cells.add(cell);
    }

    /**
     * @param columnIndex : A or BE
     * @return
     */
    public Cell find(String columnIndex) {
        return indexedBinarySearch(cells, columnIndex + index);  // 需要拼接成  A9 , BE150 然后在查找
    }

    private static Cell indexedBinarySearch(List<Cell> list, String key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Cell cell = list.get(mid);
            int cmp = cell.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return cell; // key found
        }
        return null;  // key not found
    }

}
