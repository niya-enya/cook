package top.durandal.exception;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.durandal.common.ResponseInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UrlCodeException extends AbstractErrorController {

    public UrlCodeException(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    public String getErrorPath() {
        return "error";
    }

    @RequestMapping("error")
    @ResponseBody
    public ResponseInfo error(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setStatus(HttpStatus.OK.value());
        HttpStatus httpStatus=getStatus(httpServletRequest);
        return ResponseInfo.error(httpStatus.value(),httpStatus.getReasonPhrase());
    }
}
