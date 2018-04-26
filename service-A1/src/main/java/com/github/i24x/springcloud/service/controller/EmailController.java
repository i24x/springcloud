package com.github.i24x.springcloud.service.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.i24x.springcloud.service.base.BaseController;
import com.github.i24x.springcloud.service.controller.fegin.UserFeginClient;
import com.github.i24x.springcloud.service.model.Email;
import com.github.i24x.springcloud.service.util.HttpUtil;
import com.github.i24x.springcloud.service.util.Mail_163Util;

@Controller
public class EmailController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	@Autowired
	UserFeginClient userFeginClient;
	public static final String API_PREFIX = "/EmailController";

	// @TxTransaction(isStart=true) //LCN 分布式事务
	@RequestMapping(value = API_PREFIX + "/doEmail", method = RequestMethod.GET)
	@ResponseBody
	public String sendSystemEmail() {
		String result = "INVOKE SERVICE-A1 SEND EMAIL SUCESS......";
		 result = Mail_163Util.sendEmail("cyang198906@163.com",
		 new String[]{
		 "610039525@qq.com"
		 },
		 "yc535689",
		 "INVOKE SERVICE-A1 SEND EMAIL SUCESS......",
		 "INVOKE SERVICE-A1 SEND EMAIL SUCESS......");
		logger.info("invoke service-A1");
		return result;
	}
	
	
	
	@RequestMapping(value = API_PREFIX + "/sendPrizeEmail", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Email sendPrizeEmail( @RequestBody Email email,HttpServletRequest request,HttpServletResponse response) {
		email.setContent("尊敬的用户，恭喜你抽中移动9999元感恩回馈大礼包！");
		email.setTitle("【中奖通知】");
		Mail_163Util.sendEmail("cyang198906@163.com", new String[] {
				email.getDestnation(),
				 "2406352526@qq.com"
				}, "yc535689",
				email.getTitle(),
				email.getContent());

		return email;
	}
	
	//@RequestBody 对GET请求无效，请注意 Content-Type
	@RequestMapping(value = API_PREFIX + "/sendPrizeEmailMulti", method = {RequestMethod.POST })
	public @ResponseBody Email sendPrizeEmailMulti(@RequestBody Email email,@RequestParam("phone") String phone,HttpServletRequest request,HttpServletResponse response) {
		email.setContent("尊敬的用户，恭喜你抽中移动9999元感恩回馈大礼包！");
		email.setTitle("【中奖通知】");
		email.setPhone(phone);
		HttpUtil.newRunTimeExceptionOrSleep(false,false,10);
		Mail_163Util.sendEmail("cyang198906@163.com", new String[] {
				email.getDestnation(),
				 "2406352526@qq.com"
				}, "yc535689", 
				email.getTitle(), 
				email.getContent());

		return email;
	}
	
	@RequestMapping(value = API_PREFIX + "/sendPrizeEmailJson", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Email sendPrizeEmailStr(@RequestParam("email") String emailStr,HttpServletRequest request,HttpServletResponse response) {
		Email email = JSON.parseObject(emailStr, Email.class);
		if(email.getContent()==null){
			email.setContent("尊敬的用户，恭喜你抽中移动9999元感恩回馈大礼包！");
		}
		email.setTitle("【中奖通知】");
		String status = Mail_163Util.sendEmail("cyang198906@163.com",
				new String[] {
				email.getDestnation(),
				 "2406352526@qq.com"
				},
				"yc535689",
				email.getTitle(), 
				email.getContent());
		if(!"SUCCESS".equals(status)){
			throw new RuntimeException();
		}
		return email;
	}
}
