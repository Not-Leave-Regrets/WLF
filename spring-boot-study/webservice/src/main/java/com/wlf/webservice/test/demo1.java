package com.wlf.webservice.test;

import com.wlf.webservice.service.serviceImpl.DemoServiceImpl;

public class demo1 {
 
    public static void main(String[] args) {
        DemoServiceImpl webServiceImpl = new DemoServiceImpl();
        String result = webServiceImpl.sayHello("没有说");
        System.out.println("===========================================");
        System.out.println(result);
        System.out.println("===========================================");
    }
 
}