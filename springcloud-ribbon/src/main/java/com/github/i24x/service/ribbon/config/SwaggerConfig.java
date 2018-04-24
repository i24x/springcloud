package com.github.i24x.service.ribbon.config;

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
		return new ApiInfoBuilder().title("XX项目测试").description("用于Ribbon模块1").version("1.0")
				.termsOfServiceUrl("http://www.boco.com.cn/")
				.contact(new Contact("XXX小组", "http://www.boco.com.cn/", "cyang198906@163.com")).license("XX许可")
				.licenseUrl("http://www.boco.com.cn/").build();
	}
}
