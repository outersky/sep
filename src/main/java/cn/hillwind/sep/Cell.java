package cn.hillwind.sep;

/**
 * sax方式的excel解析中，没有Cell的概念，所以需要自定义一个,方便程序处理.
 */
public class Cell implements Comparable {
    ValueType type; // 值的类型
    String value; // 值
    String ref;  // A1 , F6, BE150

    @Override
    public int compareTo(Object o) {
        if (o instanceof String) {
            String str = (String) o;
            if (str.length() != ref.length()) {
                return (ref.length() < str.length()) ? -1 : ((ref.length() == str.length()) ? 0 : 1);
            }
            return this.ref.compareTo((String) o);
        } else if (o instanceof Cell) {
            return this.compareTo(((Cell) o).ref);
        } else {
            return this.compareTo(o.toString());
        }
    }

    /**
     * The type of the data value is indicated by an attribute on the cell.
     * The value is usually in a "v" element within the cell.
     */
    enum ValueType {
        BOOL,
        ERROR,
        FORMULA,
        INLINESTR,
        SSTINDEX,
        NUMBER,
    }

}
