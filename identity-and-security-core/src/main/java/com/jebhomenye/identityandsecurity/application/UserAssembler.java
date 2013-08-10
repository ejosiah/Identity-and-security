package com.jebhomenye.identityandsecurity.application;

import javax.inject.Inject;
import javax.inject.Named;

import com.jebhomenye.identityandsecurity.domain.model.user.*;

@Named
public class UserAssembler {
	
	@Inject private UserRepository userRepository;
	@Inject private PasswordService passwordService;
	@Inject private AccessControlService accessControlService;
	
	public User assembleFrom(RegisterUserCommand registerUser){
		return new User(
				registerUser.fullName()
				, new ContactInfo(
				 	registerUser.emailAddress()
				 	, registerUser.address()
				 	, null
				 	, registerUser.primaryTelephone()
				 	, registerUser.secondaryTelephone()
				)
				, registerUser.getUsername()
				, registerUser.getPassword()
				, registerUser.getGroup()
				);
	}
}
