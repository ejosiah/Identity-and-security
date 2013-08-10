package com.jebhomenye.identityandsecurity.application;

import com.jebhomenye.identityandsecurity.domain.model.user.User;

public interface AfterUserRegistrationInterceptor {
	
	void intercept(User user);
}
