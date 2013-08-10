package com.jebhomenye.identityandsecurity.application;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Enablement;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class RegistratoinService {
	
	@Inject private Collection<BeforeUserRegistrationInterceptor> beforeRegistration;
	@Inject private Collection<AfterUserRegistrationInterceptor> afterUserRegistration;
	@Inject	private UserRepository userRepository;
	@Inject private UserAssembler userAssembler;
	@Inject private AccessControlService accessControlService;
	
	public void registerUser(RegisterUserCommand registerUserCommand){
		fireBeforeRegistration(registerUserCommand);
		User newUser = userAssembler.assembleFrom(registerUserCommand);
		fireAfterUserRegistration(newUser);
		userRepository.add(newUser);
	}
	
	private void fireBeforeRegistration(RegisterUserCommand registerUser){
		for(BeforeUserRegistrationInterceptor interceptor : beforeRegistration){
			interceptor.intercept(registerUser);
		}
	}
	
	private void fireAfterUserRegistration(User user){
		for(AfterUserRegistrationInterceptor interceptor : afterUserRegistration){
			interceptor.intercept(user);
		}
	}
	
	public void activateUser(Long userId){
		
	}
}
