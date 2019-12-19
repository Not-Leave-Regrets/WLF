package com.wlf.webservice.service.serviceImpl;

import com.wlf.webservice.service.DemoService;

import javax.jws.WebService;
import java.util.Date;

@WebService(serviceName = "DemoService", // 与接口中指定的name一致
        targetNamespace = "http://service.mq.primeton.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.wlf.webservice.service.DemoService"// 接口地址
)
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String user) {
        return user + ",现在的时间:(" + new Date()+")";
    }

    @Override
    public String sayBye(String msg) {
        return sayHello(msg) + "success";
    }

    @Override
    public User lookUser(User user) {
        return user;
    }


}
