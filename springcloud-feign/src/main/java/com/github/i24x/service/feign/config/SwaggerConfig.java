package com.github.i24x.service.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String BASEPACKAGE = "com.github.i24x";
	@Bean
	public Docket createInstanceDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BASEPACKAGE)).paths(PathSelectors.any()).build()
				.apiInfo(createInstanceApiInfo());
		return docket;
	}

	private ApiInfo createInstanceApiInfo() {
		return new ApiInfoBuilder().title("SPRING CLOUD 环境搭建").description("用于Feign模块测试").version("1.0")
				.termsOfServiceUrl("https://github.com/i24x")
				.contact(new Contact("i24x", "https://github.com/i24x", "i24x610039525@163.com")).license("转载请标明出处")
				.licenseUrl("https://github.com/i24x").build();
	}
}
