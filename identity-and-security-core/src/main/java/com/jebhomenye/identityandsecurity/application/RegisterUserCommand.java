package com.jebhomenye.identityandsecurity.application;

import com.jebhomenye.identityandsecurity.domain.model.user.Address;
import com.jebhomenye.identityandsecurity.domain.model.user.EmailAddress;
import com.jebhomenye.identityandsecurity.domain.model.user.FullName;
import com.jebhomenye.identityandsecurity.domain.model.user.Telephone;

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
	
	public FullName fullName(){
		if(firstname == null && lastname == null){
			return null;
		}
		return new FullName(firstname, lastname);
	}
	
	public Address address(){
		if(street == null && city == null && postcode == null && country == null){
			return null;
		}
		return new Address(street, postcode, city, country);
	}
	
	public Telephone primaryTelephone(){
		if(primaryTelephone == null){
			return null;
		}
		return new Telephone(getPrimaryTelephone());
	}
	
	public Telephone secondaryTelephone(){
		if(secondaryTelephone == null){
			return null;
		}
		return new Telephone(secondaryTelephone);
	}
	
	public EmailAddress emailAddress(){
		if(emailAddress == null){
			return null;
		}
		return new EmailAddress(emailAddress);
	}
}
