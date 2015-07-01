package cn.hillwind.sep;

/**
 * 列校验器
 */
public interface FormatValidator {
    /**
     *
     * @param expectFormat
     * @param cell
     * @return 错误消息，null: 没有发现错误
     */
    String validate(String expectFormat, Cell cell);

    String toTipText();
}
