package com.github.i24x.service.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SERVICE-B")
public interface UserFeginClient {
	@RequestMapping(value = "/UserController/updateDefaultUser/{name}", method = RequestMethod.GET)
	public String updateDefaultUser(@PathVariable("name") String name);
}