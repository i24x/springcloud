package com.github.i24x.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;
/**
 * 
 * @author i24x
 * service-B +sleuth+springcloud-feign
 */
@SpringBootApplication
@EnableZipkinServer
public class Sleuth_Application {

    public static void main(String[] args) {
        SpringApplication.run(Sleuth_Application.class, args);
    }
}