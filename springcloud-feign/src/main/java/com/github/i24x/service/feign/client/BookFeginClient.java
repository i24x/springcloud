package com.github.i24x.service.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.i24x.service.model.Book;
import com.github.i24x.service.model.User;
@FeignClient(name = "SERVICE-B")
public interface BookFeginClient {
	public static final String API_PREFIX = "BookController";
	@RequestMapping(value = API_PREFIX + "/orderBook/{name}", method = RequestMethod.POST)
	public Book orderBook(@RequestBody User user,@PathVariable("name") String name);
}