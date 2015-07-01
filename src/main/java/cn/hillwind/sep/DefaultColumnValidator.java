package cn.hillwind.sep;

/**
 *
 */
public class DefaultColumnValidator implements ColumnValidator {

    /**
     * @param columnDesc
     * @param value
     * @return 错误消息，null: 没有发现错误
     */
    @Override
    public String validate(ColumnDesc columnDesc, Cell value) {
        return null;
    }
}
