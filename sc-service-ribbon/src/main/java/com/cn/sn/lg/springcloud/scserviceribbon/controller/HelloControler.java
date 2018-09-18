package com.cn.sn.lg.springcloud.scserviceribbon.controller;

import com.cn.sn.lg.springcloud.scserviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    /**
     * 在controller中用调用HelloService 的方法
     * @param name  name
     * @return
     */
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

    /*
        需要起一个eureka-server，多个eureka-client，然后起ribbon服务
        在浏览器上多次访问http://localhost:8764/hi?name=forezp，浏览器交替显示：
        hi lg,i am from port:8762
        hi lg,i am from port:8763
    */

}
