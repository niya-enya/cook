package top.durandal.http;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ResStatus {
    OK (200,"OK"),ERROR (-1,"ERROR");
    private Integer code;
    private String msg;

    ResStatus(Integer i, String s) {
        code=i;
        msg=s;
    }

    public Map<String,Object> map(){
        Map<String, Object> linkMap=new LinkedHashMap<String,Object>();
        linkMap.put("code",getCode());
        linkMap.put("msg",getMsg());
        return linkMap;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
