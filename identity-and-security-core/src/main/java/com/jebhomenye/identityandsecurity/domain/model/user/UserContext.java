package com.jebhomenye.identityandsecurity.domain.model.user;

public interface UserContext {
	
	IdentityUser currentUser();
	
	void setCurrentUser(IdentityUser user);
}
