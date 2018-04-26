package com.github.i24x.service.feign.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.i24x.service.model.Book;
import com.github.i24x.service.model.User;
@Component
public class BookHystrixFallback implements BookFeginClient {
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookHystrixFallback.class);
	@Override
	public Book orderBook(User user, String name) {
		LOGGER.info("异常发生，进入fallback方法，接收的参数： {}",name);
		Book book = new Book();
		book.setLabelCn("Iron Man");
		return book;
	}

}
