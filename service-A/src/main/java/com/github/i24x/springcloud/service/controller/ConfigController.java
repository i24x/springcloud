package com.github.i24x.springcloud.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
	 private static final String API_PRIFIX="/ConfigController";
	 @Value("${syncTask.cron}")
	 private String cron;
	 
	 @RequestMapping(API_PRIFIX+"/getTaskCron")
	 public String getTaskCron(){
		return this.cron;
	 }
}
