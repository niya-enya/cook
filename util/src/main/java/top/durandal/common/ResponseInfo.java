package top.durandal.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import top.durandal.http.ResStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInfo{
    private Integer code;
    private String msg;
    private Object data;

    public ResponseInfo(ResStatus resStatus, Object object){
        this.code=resStatus.getCode();
        this.msg=resStatus.getMsg();
        this.data=object;
    }

    public static ResponseInfo success(){
        return success(null);
    }

    public static ResponseInfo success(Object o){
        return new ResponseInfo(ResStatus.OK,o);
    }

    public static ResponseInfo error(Object msg){
        return error(ResStatus.ERROR.getCode(), msg.toString());
    }

    public static ResponseInfo error(Integer code,String msg){
        return new ResponseInfo(code, msg, null);

    }
}
