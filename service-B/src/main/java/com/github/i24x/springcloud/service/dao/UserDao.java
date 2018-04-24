package com.github.i24x.springcloud.service.dao;

import com.github.i24x.springcloud.service.model.User;

public interface UserDao {
	public int  updateUser(int id,String name);
	public User selectUser(int id);
}
	
