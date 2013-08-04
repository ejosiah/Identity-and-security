package com.jebhomenye.identityandsecurity.application;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import com.jebhomenye.identityandsecurity.domain.model.user.Enablement;
import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class RegistratoinService {
	
	@Inject	private UserRepository userRepository;
	@Inject private UserAssembler userAssembler;
	
	public void registerUser(RegisterUserCommand registerUserCommand){
		User newUser = userAssembler.assembleFrom(registerUserCommand);
		newUser.enablement(new Enablement(DateTime.now(), DateTime.now().plusYears(1), true));
		userRepository.add(newUser);
	}
}
