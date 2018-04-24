package com.github.i24x.springcloud.service.gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.i24x.springcloud.service.gateway.config.DefineFilterProcessor;
import com.netflix.zuul.FilterProcessor;

@EnableZuulProxy
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
public class StartupApplication_API {
	public static void main(String[] args) {
		FilterProcessor.setProcessor(new DefineFilterProcessor());
		SpringApplication.run(StartupApplication_API.class, args);
	}
}
