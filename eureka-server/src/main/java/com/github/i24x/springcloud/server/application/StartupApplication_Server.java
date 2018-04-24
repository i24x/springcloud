package com.github.i24x.springcloud.server.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StartupApplication_Server {
    public static void main(String[] args) {
        new SpringApplicationBuilder(StartupApplication_Server.class).web(true).run(args);
    }
}
