package com.github.i24x.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
/**
 * 本案例基于http整合路由熔断信息
 * @author i24x
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class TurbineApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(TurbineApplication.class).web(true).run(args);
  }
}