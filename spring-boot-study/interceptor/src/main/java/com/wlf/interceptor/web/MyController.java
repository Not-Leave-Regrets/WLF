package com.wlf.interceptor.web;
 
import com.wlf.interceptor.authen.access.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MyController {
    
    @RequestMapping("/index")
    @Logger(operations = "测试logger")
    public String index(){
        return "hello!";
    }
    
}