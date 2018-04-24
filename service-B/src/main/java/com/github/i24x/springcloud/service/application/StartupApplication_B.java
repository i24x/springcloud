package com.github.i24x.springcloud.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  
@EnableAutoConfiguration 
@ComponentScan(basePackages="com.github.i24x.springcloud.service")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableScheduling
public class StartupApplication_B {
	public static void main(String[] args) {
		SpringApplication.run(StartupApplication_B.class, args);
	}
}
