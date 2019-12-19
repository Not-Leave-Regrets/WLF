package com.wlf.webservice.service;


import com.wlf.webservice.service.serviceImpl.User;

import javax.jws.WebService;
//2.创建服务端接口

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://service.mq.primeton.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    public String sayHello(String user);

    public String sayBye(String msg);

    public User lookUser(User user);
}