package com.github.i24x.springcloud.service.bo;

import com.github.i24x.springcloud.service.model.User;

public interface UserService {
	User updateDefaultUser(String name);
	User getDefaultUser();
}
