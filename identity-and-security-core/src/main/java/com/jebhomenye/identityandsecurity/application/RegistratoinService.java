package com.jebhomenye.identityandsecurity.application;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Enablement;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class RegistratoinService {
	
	@Inject	private UserRepository userRepository;
	@Inject private UserAssembler userAssembler;
	@Inject private AccessControlService accessControlService;
	
	public void registerUser(RegisterUserCommand registerUserCommand){
		IdentityUser newUser = userAssembler.assembleFrom(registerUserCommand);
		newUser.enablement(new Enablement(DateTime.now(), DateTime.now().plusYears(1), true));
		addUserToGroup(newUser, registerUserCommand.getGroup());
		userRepository.add(newUser);
	}

	private void addUserToGroup(IdentityUser newUser, String groupName) {
		if(groupName != null){
			Group group = accessControlService.getGroupByName(groupName);
			if(group == null){
				throw new IllegalArgumentException("invalid group : " + groupName);
			}
			newUser.group(group);
		}
		
	}
	
	public void activateUser(Long userId){
		
	}
}
