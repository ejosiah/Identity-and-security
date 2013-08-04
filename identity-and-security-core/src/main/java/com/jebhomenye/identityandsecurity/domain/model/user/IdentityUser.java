package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.jebhomenye.domain.common.core.Entity;

@Data
@Builder
@Accessors(fluent=true)
public class IdentityUser implements Entity<IdentityUser, UserId> {
	
	private UserId id;
	private FullName fullName;
	private ContactInfo contactInfo;
	private Enablement enablement;
	private String username;
	private String password;
	private Group group;
	
	IdentityUser(){
		
	}
	
	private IdentityUser(UserId id, FullName fullName, ContactInfo contactInfo, Enablement enablement
			,String username, String password, Group group){
		id(id);
		fullName(fullName);
		username(username);
		password(password);
		this.contactInfo = contactInfo;
		this.enablement = enablement;
		this.group = group;
	}
	
	private void id(UserId id){
		Validate.notNull(id, "UserId is required.");
		this.id = id;
	}
	
	private void fullName(FullName fullName){
		Validate.notNull(fullName, "full name is required");
		this.fullName = fullName;
	}
	
	private void username(String username){
		Validate.notNull(username, "username is required");
		this.username = username;
	}
	
	private void password(String password){
		Validate.notNull(password, "password is required");
		this.password = password;
	}
	
	public boolean isEnabled(){
		return enablement.isEnabled();
	}
	
	public boolean sameIdentityAs(IdentityUser other) {
		return this.id.sameValuesAs(other.id);
	}
	
	public void changePassword(String currentPassword, String newPassword){
		// TODO change password;
	}
	
	public void changeContactInfo(ContactInfo newContactInfo){
		// TODO - change contact info
	}
}
