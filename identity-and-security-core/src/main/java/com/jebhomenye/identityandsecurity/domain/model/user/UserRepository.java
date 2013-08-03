package com.jebhomenye.identityandsecurity.domain.model.user;

public interface UserRepository {
	
	void add(User user);
	
	User userOfUsername(String username);
	
	UserId nextIdentity();
}
