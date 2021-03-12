package top.durandal.exception;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.durandal.common.ResponseInfo;
import top.durandal.http.ResStatus;

@ControllerAdvice
@ResponseBody
public class OverallExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseInfo exceptionHandler(Exception e){
//        return ResponseInfo.error(ResStatus.ERROR.getCode(),ResStatus.ERROR.getMsg());
//    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseInfo usernameNotFoundExceptionHandler(UsernameNotFoundException e){
        return ResponseInfo.error(ResStatus.ERROR.getCode(),e.getMessage());
    }
}
