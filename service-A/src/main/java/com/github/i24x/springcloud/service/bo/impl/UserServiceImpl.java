package com.github.i24x.springcloud.service.bo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.StringUtils;
import com.github.i24x.springcloud.service.bo.UserService;
import com.github.i24x.springcloud.service.dao.UserDao;
import com.github.i24x.springcloud.service.model.User;
import com.github.i24x.springcloud.service.util.DateUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service("UserService")
//@RestController
public class UserServiceImpl implements UserService {
	
	private static Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userMapper;
//	@Resource(name = "GenericDAO")
//	private GenericDAO GenericDAO;
	
	 @Autowired
     RestTemplate restTemplate;
//	@RequestMapping(value="/UserServiceImpl/handUser")
//	@Transactional(value = "txManager")
	@Override
	public User updateDefaultUser(String name) {
		String time = DateUtil.getNowTimeToDefaultString();
		int N= userMapper.updateUser(12345678, name+"@"+time);
		logger.info("更新数据"+N+"条");
		User user = userMapper.selectUser(12345678);
		String f = "true";
		if(StringUtils.equals("true", f)){
//			throw new RuntimeException("roll back test!");
		}
		return user;
	}

	@Override
	public User getDefaultUser() {
		String f = "true";
		if(StringUtils.equals("true", f)){
//			throw new RuntimeException("roll back test!");
		}
		User user = userMapper.selectUser(12345678);
		return user;
	}
	@HystrixCommand(fallbackMethod = "fallback")
	@Override
	public User getUser() {
		String url = "http://eureka-provider2"+"/UserController/getDefaultUser";
		User r = restTemplate.getForObject(url, User.class);
		return r;
	}
	
	public User fallback() {
		User r  = new User();
		r.setName("测试服务降级，返回默认角色");
        return r;
    }
}
