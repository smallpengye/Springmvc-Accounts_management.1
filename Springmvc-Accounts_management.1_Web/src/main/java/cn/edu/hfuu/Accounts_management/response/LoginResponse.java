package cn.edu.hfuu.Accounts_management.response;

import java.util.List;
import java.util.Map;

/**
 * Created by 志鹏 on 2016/8/1.
 */
public class LoginResponse {

    private boolean success;

    private  String info;
    private List<Map<Object,Object>> map;

    public List<Map<Object, Object>> getMap() {
        return map;
    }

    public void setMap(List<Map<Object, Object>> map) {
        this.map = map;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
