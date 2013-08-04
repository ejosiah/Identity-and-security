package com.events.adapter;

import javax.inject.Inject;
import javax.inject.Named;

import com.events.domain.User;
import com.events.domain.UserId;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class UserAdapter {
	
	@Inject
	private UserRepository userRepository;
	
	public User userFor(String username){
		IdentityUser identityUser = userRepository.userOfUsername(username);
		return new User(
				new UserId(identityUser.id().value())
				, identityUser.username());
	}
}
