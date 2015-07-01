package cn.hillwind.sep;

/**
 * 列
 */
public class ColumnDesc {

    /**
     * 列名称（用于和Java对象的属性名称对应）
     */
    String name;

    /**
     * 列在Excel中的显示标题
     */
    String title;

    /**
     * 列的Excel索引位置，第一列为0
     */
    int columnIndex;

    /**
     * 字符串的列名, 与columnIndex对应
     */
    String column;

    /**
     * 关键字段标记。 一行中，如果发现有任何关键标记的值为空，则表示为空行，会自动跳过解析。
     * 对于key字段，allowBlank自动为false
     */
    boolean key = false;

    /**
     * 列对应的权限，注意当读、写权限不相同时，可以用readRoles/writeRoles进一步细化限制
     * mobile,design,supervision,construction
     */
    String roles;

    /**
     * 列对应的读权限,即下载文件中是否包含该字段。该属性优先级比roles高。指定了该字段，则读取的时候以该字段为准。
     * mobile,design,supervision,construction
     */
    String readRoles;

    /**
     * 列对应的修改权限, 即是否可以上传/修改该字段。 该属性优先级比roles高。指定了该字段，则上传/修改的时候以该字段为准。
     * mobile,design,supervision,construction
     */
    String modifyRoles;

    /**
     * 列值的格式: string, date, number ...
     */
    ColumnDataFormat dataFormat;

    /**
     * 是否允许为空，默认为允许。为空时，不进行有效性校验。
     */
    boolean allowBlank = true;

    /**
     * 允许的值范围，用于限制下拉框内容;没有表示不限制
     */
    String[] allowValues;

    String renderer; // class name of ColumnRenderer. default to DefaultColumnRenderer
    String rendererOptions; // renderer 执行时的配置项

    public boolean canRead(String[] roles){
        // 所有的key字段，显示/下载时都要带出
        if(isKey()){
            return true;
        }
        if( StringUtil.isEmpty(this.roles) && StringUtil.isEmpty(this.readRoles) ){
            return true;
        }
        // 如果明确了none，则谁都不能读
        if("none".equalsIgnoreCase(this.roles) || "none".equalsIgnoreCase(this.readRoles)){
            return false;
        }
        if(roles==null || roles.length==0){
            return false;
        }
        for(String r : roles){
            if(canRead(r)){
                return true;
            }
        }
        return false;
    }

    public boolean canModify(String[] roles){
        // 所有的key字段，上传/修改时都要填上，否则无法对应到原记录
        if(isKey()){
            return true;
        }
        if( StringUtil.isEmpty(this.roles) && StringUtil.isEmpty(this.modifyRoles) ){
            return true;
        }
        // 如果明确了none，则谁都不能改。
        if("none".equalsIgnoreCase(this.roles) || "none".equalsIgnoreCase(this.modifyRoles)){
            return false;
        }
        if(roles==null || roles.length==0){
            return false;
        }
        for(String r : roles){
            if(canModify(r)){
                return true;
            }
        }
        return false;
    }

    private boolean canRead(String role){
        String r = this.roles;
        if( !StringUtil.isEmpty(readRoles) ){
            r = readRoles;
        }
        return (","+r + ",").contains(","+role+",");
    }

    private boolean canModify(String role){
        String r = this.roles;
        if( !StringUtil.isEmpty(modifyRoles) ){
            r = modifyRoles;
        }
        return (","+r + ",").contains("," + role + ",");
    }

    public String getColumn() {
        if(column==null){
            column = indexToName(columnIndex);
        }
        return column;
    }

    /**
     * Converts an Excel column name like "C" to a zero-based index.
     *
     * @param name
     * @return Index corresponding to the specified name
     */
    public static int nameToIndex(String name) {
        int column = -1;
        for (int i = 0; i < name.length(); ++i) {
            int c = name.charAt(i);
            column = (column + 1) * 26 + c - 'A';
        }
        return column;
    }

    /**
     *
     * @param columnIndex  zero-based index.
     * @return
     */
    public static String indexToName(int columnIndex) {
        String name = "" + (char) (columnIndex % 26 + 'A');
        while(columnIndex>=26){
            columnIndex = columnIndex / 26 - 1 ;
            char last =(char) ( columnIndex % 26 + 'A');
            name = last + name;
        }
        return name;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getReadRoles() {
        return readRoles;
    }

    public void setReadRoles(String readRoles) {
        this.readRoles = readRoles;
    }

    public String getModifyRoles() {
        return modifyRoles;
    }

    public void setModifyRoles(String modifyRoles) {
        this.modifyRoles = modifyRoles;
    }

    public ColumnDataFormat getDataFormat() {
        if(dataFormat==null){
            return ColumnDataFormat.string;
        }
        return dataFormat;
    }

    public void setDataFormat(ColumnDataFormat dataFormat) {
        this.dataFormat = dataFormat;
    }

    // key 列，不允许为空
    public boolean isAllowBlank() {
        return key ? false : allowBlank;
    }

    public void setAllowBlank(boolean allowBlank) {
        this.allowBlank = allowBlank;
    }

    public String[] getAllowValues() {
        return allowValues;
    }

    public void setAllowValues(String[] allowValues) {
        this.allowValues = allowValues;
    }

    public String getRendererOptions() {
        return rendererOptions;
    }

    public void setRendererOptions(String rendererOptions) {
        this.rendererOptions = rendererOptions;
    }
}
