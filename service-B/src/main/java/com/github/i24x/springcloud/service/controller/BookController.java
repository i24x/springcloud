package com.github.i24x.springcloud.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.i24x.service.model.Book;
import com.github.i24x.service.model.User;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	public static final String API_PREFIX = "BookController";
	
	@RequestMapping(value = API_PREFIX + "/orderBook/{name}", method = RequestMethod.POST)
	@ResponseBody
	public Book orderBook(@RequestBody User user,@PathVariable("name") String name) {
		logger.info(user.toString());
		Book book = new Book();
		book.setLabelCn(name);
		book.setAuthor("小米");
		return book;
	}
}
