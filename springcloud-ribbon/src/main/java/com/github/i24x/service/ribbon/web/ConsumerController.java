package com.github.i24x.service.ribbon.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.github.i24x.service.model.Email;
import com.github.i24x.service.ribbon.service.EmailService;


@RestController
public class ConsumerController {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EmailService emailService;
    
//    @Autowired  
//    private LoadBalancerClient loadBalancerClient;  

    @RequestMapping(value = "/doEmail", method = RequestMethod.GET)
    public String doEmail(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response) {
//    	this.loadBalancerClient.choose("service-A");//随机访问策略
    	Email email  = new Email();
    	email.setDestnation("610039525@qq.com");
    	email.setContent("尊敬的用户，恭喜你抽中移动9999元感恩回馈大礼包！");
		email.setTitle("【中奖通知】");
		Map<String,Object> vars = new HashMap<String,Object>();
		vars.put("email", JSON.toJSONString(email));
		Email result =  null;
		//@RequestBody
//		result = restTemplate.postForObject("http://service-A/EmailController/sendPrizeEmail",email, Email.class);
		logger.info(JSON.toJSONString(result));
		//@RequestParam JSON {} 被错误认为是占位符 
		result = restTemplate.getForObject("http://service-A/EmailController/sendPrizeEmailStr?email={email}",Email.class,JSON.toJSONString(email));
		logger.info(JSON.toJSONString(result));
		//http://service-A/EmailController/doEmail/{title}
		//@PathVariable
    	return restTemplate.getForEntity("http://service-A/EmailController/doEmail", String.class).getBody();
    }
    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String sendEmail(@RequestParam("destnation") String destnation,@RequestParam("content") String content ){
		return emailService.sendEmail(destnation, content);
    }
    
}