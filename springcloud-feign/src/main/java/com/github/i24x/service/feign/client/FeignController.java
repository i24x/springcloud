package com.github.i24x.service.feign.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.i24x.service.model.Book;
import com.github.i24x.service.model.User;

@RestController
public class FeignController {
	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
	@Autowired
	private UserFeginClient userFeginClient;

	@Autowired
	private BookFeginClient bookFeginClient;

	@RequestMapping(value = "FeignController/updateDefaultUser", method = RequestMethod.GET)
	public String modUser(@RequestParam("name") String name) {
		String string = this.userFeginClient.updateDefaultUser(name);
		return string;
	}

	@RequestMapping(value = "FeignController/orderBook", method = RequestMethod.GET)
	public @ResponseBody
	Book orderBook(@RequestParam("name") String name) {
		logger.info("******************<>>>>>>>>>>>");
		User user = new User();
		user.setName("苹果");
		Book book = bookFeginClient.orderBook(user, name);
		return book;
	}
}