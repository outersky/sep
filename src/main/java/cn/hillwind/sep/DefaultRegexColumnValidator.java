package cn.hillwind.sep;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 默认
 */
public class DefaultRegexColumnValidator implements ColumnValidator {

    private static Map<String,FormatValidator> validatorMap = new HashMap<String, FormatValidator>();

    public static void registerFormatValidator(String name , FormatValidator validator){
        validatorMap.put(name,validator);
    }

    public DefaultRegexColumnValidator(){
    }

    /**
     *
     * @param columnDesc
     * @param cell
     * @return 错误消息，null: 没有发现错误
     */
    public String validate(ColumnDesc columnDesc, Cell cell) {
        // 如果单元格本身就是ERROR,直接失败.
        if(cell.type== Cell.ValueType.ERROR){
            return "单元格ERROR.";
        }
        //如果允许为空
        if(cell==null || cell.value.trim().length()==0){
            if(columnDesc.allowBlank ){
                return null;
            }else{
                return "不能为空";
            }
        }

        if(columnDesc.allowValues==null || columnDesc.allowValues.length==0){
            return null;
        }

        for(String item : columnDesc.allowValues){
            if(validate0(item,cell)){
                return null;
            }
        }

        return "内容格式 [" + cell.value + "] 有误，允许格式为：" + toAllowString(columnDesc.allowValues);
    }

    private static String toAllowString(String[] formats){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(String f : formats){
            sb.append(",").append(toTipText(f));
        }
        sb.deleteCharAt(1);
        sb.append(']');
        return sb.toString();
    }

    private static Pattern regexDetect = Pattern.compile("^\\^.*\\$$");

    /**
     *
     * @param item  ColumnDesc 中配置的允许的值，可能是正则表达式，也可以是普通字符串
     * @param cell 被验证的Excel中Cell的值
     * @return
     */
    private static boolean validate0(String item, Cell cell) {
        if(item.startsWith(":")){
            return validate2(item,cell);
        }else if(regexDetect.matcher(item).matches()){
        // 如果是正则表达式
            Pattern p = getPattern(item);
            return p.matcher(cell.value).matches();
        }else{
            // 普通字符串完整匹配
            return item.equals(cell.value);
        }
    }

    private static Pattern moneyDetect = Pattern.compile("^(\\d\\.)*$");
    private static boolean validate2(String item, Cell cell){
        if(":date".equalsIgnoreCase(item)) {
            return cell.type==Cell.ValueType.NUMBER;
        }else if(":money".equalsIgnoreCase(item)){
            if(cell.type==Cell.ValueType.NUMBER){
                return true;
            }
            if(cell.type==Cell.ValueType.SSTINDEX){
                return moneyDetect.matcher(cell.value).matches();
            }
            return false;
        }else{
            String name = item.substring(1);
            FormatValidator validator = validatorMap.get( name );
            if(validator!=null){
                String msg = validator.validate(name,cell);
                return msg==null;
            }
            //不支持的类型
            return false;
        }
    }

    private static String toTipText(String item){
        if(item.startsWith(":")){
            if(":date".equalsIgnoreCase(item)) {
                return "日期";
            }else if(":money".equalsIgnoreCase(item)){
                return "金额";
            }else{
                String name = item.substring(1);
                FormatValidator validator = validatorMap.get( name );
                if(validator!=null){
                    return validator.toTipText();
                }
                return item;
            }
        }else {
            return item;
        }
    }

    private static Map<String,Pattern> cache = new HashMap<String, Pattern>();
    private static Pattern getPattern(String str){
        Pattern p = cache.get(str);
        if(p==null){
            p = Pattern.compile(str);
            cache.put(str,p);
        }
        return p;
    }
    
}
