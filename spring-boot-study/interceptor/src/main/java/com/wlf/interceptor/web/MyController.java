package com.wlf.interceptor.web;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MyController {
    
    @RequestMapping("/index")
    public String index(){
        return "hello!";
    }
    
}