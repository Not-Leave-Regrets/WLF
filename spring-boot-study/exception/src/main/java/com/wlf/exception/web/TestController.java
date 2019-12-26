package com.wlf.exception.web;

import com.wlf.exception.config.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TestController {

    @GetMapping("/exception")
    public String test(){
        throw new MyException("100","这是一个自定义异常");
    }


}
