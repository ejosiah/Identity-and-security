package com.jebhomenye.identityandsecurity.application;

public interface BeforeUserRegistrationInterceptor {
	
	void intercept(RegisterUserCommand registerUser);
}
