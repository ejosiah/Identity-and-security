package com.jebhomenye.identityandsecurity.application;

import javax.inject.Inject;
import javax.inject.Named;

import com.jebhomenye.identityandsecurity.domain.model.user.*;

@Named
public class UserAssembler {
	
	@Inject private UserRepository userRepository;
	@Inject private PasswordService passwordService;
	@Inject private AccessControlService accessControlService;
	
	public User assembleFrom(RegisterUserCommand registerUserCommand){
		return User.builder()
				.username(registerUserCommand.getUsername())
				.password(passwordService.encyrpt(registerUserCommand.getPassword()))
				.id(userRepository.nextIdentity())
				.fullName(new FullName(registerUserCommand.getFirstname()
						, registerUserCommand.getLastname()))
				.contactInfo(new ContactInfo(
						new EmailAddress(registerUserCommand.getEmailAddress())
						, new Address(
								registerUserCommand.getStreet()
								, registerUserCommand.getPostcode()
								, registerUserCommand.getCity()
								, registerUserCommand.getCountry())
						, null
						, (registerUserCommand.getPrimaryTelephone()  != null ?
							new Telephone(registerUserCommand.getPrimaryTelephone()) : null)
						, (registerUserCommand.getSecondaryTelephone() != null ?
							new Telephone(registerUserCommand.getSecondaryTelephone()) : null)))
				.group(accessControlService.getGroupByName(registerUserCommand.getGroup()))
			.build();
	}
}
