package com.zzjcy.eureka.client.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @description
 * @date 2018/5/28
 */
@RestController
public class ProviderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Value("${server.port}")
    private int serverPort = 0;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println(eurekaInstanceConfig.getInstanceId());
        System.out.println(eurekaInstanceConfig.getHostName(false));
        return "Hello, Spring Cloud! My port is " + String.valueOf(serverPort);
    }

    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer r = a + b;
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}
