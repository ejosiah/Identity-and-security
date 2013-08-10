package com.jebhomenye.identityandsecurity.domain.model.user;

public interface UserContext {
	
	User currentUser();
	
	void setCurrentUser(User user);
}
