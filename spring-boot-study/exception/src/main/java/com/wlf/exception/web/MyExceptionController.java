package com.wlf.exception.web;


import com.wlf.exception.config.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {
    @ResponseBody
    @ExceptionHandler(MyException.class)
    public Map errorHandler(MyException e){
        Map map =new HashMap();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }
}
