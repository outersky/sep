package cn.hillwind.sep;

/**
 * 列校验器
 */
public interface ColumnValidator {
    /**
     *
     * @param columnDesc
     * @param value
     * @return 错误消息，null: 没有发现错误
     */
    String validate(ColumnDesc columnDesc, Cell value);
}
