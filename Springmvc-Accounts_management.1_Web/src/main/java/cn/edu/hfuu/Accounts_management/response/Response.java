package cn.edu.hfuu.Accounts_management.response;

/**
 * Created by 志鹏 on 2016/8/1.
 */
public class Response {

    private String code;

    private String msg;

    private Object data;




    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
