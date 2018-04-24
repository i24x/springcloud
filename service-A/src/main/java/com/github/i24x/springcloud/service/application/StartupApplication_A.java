package com.github.i24x.springcloud.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication//组合注解 @Configuration、@EnableAutoConfiguration 、 @ComponentScan
//@SpringCloudApplication //组合注解 SpringBootApplication+EnableDiscoveryClient+EnableCircuitBreaker

//@EnableScheduling //计划任务
@Configuration  //<beans>
@EnableAutoConfiguration 
@ComponentScan(basePackages={"com.github.i24x.springcloud.service"}/*,excludeFilters={
		@Filter(type = FilterType.REGEX,
				pattern = {"com.github.caoyeung.controller.fegin"})}*/
)
@EnableFeignClients({"com.github.i24x.springcloud.service.controller.fegin"}) //Fegin 必须定义basePackages
@EnableDiscoveryClient //Eureka Client
@EnableCircuitBreaker //Hystrix 服务降级 线程隔离 路由中断
@EnableHystrixDashboard //Hystrix 监控面板
@EnableTurbine //Hystrix 监控面板聚合
public class StartupApplication_A {	
	
	@Bean
	@LoadBalanced //Ribbon
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StartupApplication_A.class, args);
	}
}
