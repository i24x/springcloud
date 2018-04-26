package com.github.i24x.service.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.github.i24x.service.model.Email;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmailService {
	@Autowired
    private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "fallback")
	public String sendEmail(@RequestParam String destnation,@RequestParam String content){
		Email email  = new Email();
    	email.setDestnation(destnation);
    	email.setContent(content);
		email.setTitle("【中奖通知】");
		Email result = restTemplate.getForObject("http://service-A/EmailController/sendPrizeEmailJson?email={email}",Email.class,JSON.toJSONString(email));
		return JSON.toJSONString(result);
	}
	@SuppressWarnings("unused")
	private String fallback(@RequestParam String destnation,@RequestParam String content){
		return "Error";
	}
	
	
}
