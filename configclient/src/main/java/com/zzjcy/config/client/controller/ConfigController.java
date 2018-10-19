package com.zzjcy.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description
 * @date 2018/6/12
 */
@RestController
@RequestMapping("/cfg")
public class ConfigController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo + "——";
    }
}
