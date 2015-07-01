package cn.hillwind.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析时需要用到的
 */
public class Option {

    /**
     * 当前用户具有的role
     */
    private String[] roles;

    /**
     * 解析时最大错误次数，超过此数字即停止解析。
     */
    private int maxErrorCount = 10;

    /**
     * 错误上下文，用于记录解析、导出时发生的错误。
     */
    protected List<String> parseErrorList = new ArrayList<String>();

    private ColumnRenderer columnRenderer = new DefaultColumnRenderer();
    private ColumnValidator columnValidator = new DefaultRegexColumnValidator();

    /**
     * 其他属性
     */
    private Map<String,Object> extraProps = new HashMap<String, Object>();


    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public int getMaxErrorCount() {
        return maxErrorCount;
    }

    public void setMaxErrorCount(int maxErrorCount) {
        this.maxErrorCount = maxErrorCount;
    }

    public int getErrorCount() {
        return parseErrorList.size();
    }

    public void addError(String errorInfo) throws  ParseErrorListException {
        parseErrorList.add(errorInfo);
        if (getErrorCount() >= getMaxErrorCount()) {
            throw new ParseErrorListException(parseErrorList);
        }
    }

    public List<String> getErrorList() {
        return parseErrorList;
    }

    public Map<String, Object> getExtraProps() {
        return extraProps;
    }

    public void setExtraProp(String name, Object prop) {
        this.extraProps.put(name,prop);
    }

    public ColumnValidator getColumnValidator() {
        return columnValidator;
    }

    public void setColumnValidator(ColumnValidator columnValidator) {
        this.columnValidator = columnValidator;
    }

    public ColumnRenderer getColumnRenderer() {
        return columnRenderer;
    }

    public void setColumnRenderer(ColumnRenderer columnRenderer) {
        this.columnRenderer = columnRenderer;
    }
}
