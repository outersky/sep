package cn.hillwind.sep;

import java.util.List;

/**
 *
 */
public class ParseErrorListException extends RuntimeException {

    public ParseErrorListException(List<String> errorList){
        this.errorList = errorList;
    }

    private List<String> errorList;

    public int getCount() {
        return errorList.size();
    }

    public void add(String errorInfo) {
        if (errorInfo != null) {
            errorList.add(errorInfo);
        }
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public String toErrorString(){
        StringBuilder sb = new StringBuilder();
        for(String err : getErrorList()){
            sb.append("\n").append(err);
        }
        return sb.toString();
    }
}
