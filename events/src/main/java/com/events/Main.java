package com.events;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jebhomenye.identityandsecurity.application.RegisterUserCommand;
import com.jebhomenye.identityandsecurity.application.RegistratoinService;
import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.Role;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

public class Main {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:events.spring.xml");
		RegisterUserCommand command = 
				RegisterUserCommand.builder()
					.username("ejosiah")
					.password("junior1983")
					.firstname("Josiah")
					.lastname("Ebhomenye")
					.street("17 Mead Road")
					.city("Edgware")
					.postcode("HA8 6LH")
					.country("United Kingdom")
					.emailAddress("jebhomenye@yahoo.com")
					.primaryTelephone("078-542-00230")
					.group("super_user")
				.build();
		
		RegistratoinService registrationService = context.getBean(RegistratoinService.class);
		registrationService.registerUser(command);
		
		/*
		Role user = new Role("ROLE_USER");
		Role admin = new Role("ROLE_ADMIN");
		
		Group userGroup = new Group("user", user);
		Group superUserGroup = new Group("super_user", Arrays.asList(user, admin));
		
		AccessControlService accessControlService = context.getBean(AccessControlService.class);
		
		
		accessControlService.createGroup(userGroup);
		accessControlService.createGroup(superUserGroup);*/
		
		UserRepository userRepo = context.getBean(UserRepository.class);
		IdentityUser user = userRepo.userOfUsername("ejosiah");
		System.out.println(user);
	}	
}
