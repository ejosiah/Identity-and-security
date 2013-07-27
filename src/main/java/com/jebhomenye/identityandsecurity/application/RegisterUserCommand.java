package com.jebhomenye.identityandsecurity.application;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class RegisterUserCommand {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	private String emailAddress;
	private String street;
	private String city;
	private String postcode;
	private String country;
	
	private String primaryTelephone;
	private String secondaryTelephone;
	
	private String group;
}
