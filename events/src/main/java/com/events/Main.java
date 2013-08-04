package com.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jebhomenye.identityandsecurity.application.RegisterUserCommand;
import com.jebhomenye.identityandsecurity.application.RegistratoinService;

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
					.group("member")
				.build();
		
		RegistratoinService registrationService = context.getBean(RegistratoinService.class);
		registrationService.registerUser(command);
	}	
}
