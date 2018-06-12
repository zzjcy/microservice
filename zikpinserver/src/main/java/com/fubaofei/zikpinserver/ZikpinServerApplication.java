package com.fubaofei.zikpinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.stream.SleuthStreamAutoConfiguration;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication(exclude = SleuthStreamAutoConfiguration.class)
@EnableZipkinServer
public class ZikpinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZikpinServerApplication.class, args);
    }
}
