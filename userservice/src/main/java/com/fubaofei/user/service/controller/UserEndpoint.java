package com.fubaofei.user.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description
 * @date 2018/5/29
 */
@RestController
@RequestMapping("/users")
public class UserEndpoint {

    @Value("${server.port:2200}")
    private int serverPort = 2200;

    @RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
    public User detail(@PathVariable String loginName) {
        String memos = "I come form " + this.serverPort;
        return new User(loginName, loginName, "/avatar/default.png", memos);
    }
}
