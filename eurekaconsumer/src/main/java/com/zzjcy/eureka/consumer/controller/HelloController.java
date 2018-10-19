package com.zzjcy.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author Administrator
 * @description
 * @date 2018/5/31
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello", String.class).getBody();
    }

    @GetMapping(value = "/helloEx")
    public String helloEx() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-HELLO");
        URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));
        return new RestTemplate().getForEntity(helloUri, String.class).getBody();
    }

}
