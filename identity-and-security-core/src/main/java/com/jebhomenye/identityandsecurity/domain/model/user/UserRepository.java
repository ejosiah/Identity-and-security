package com.jebhomenye.identityandsecurity.domain.model.user;

public interface UserRepository {
	
	void add(IdentityUser user);
	
	IdentityUser userOfUsername(String username);
	
	UserId nextIdentity();
}
