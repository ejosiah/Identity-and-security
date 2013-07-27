package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.jebhomenye.domain.common.core.Entity;

@Data
@Builder
@Accessors(fluent=true)
public class User implements Entity<User, UserId> {
	private  UserId id;
	private FullName fullName;
	private ContactInfo contactInfo;
	private Enablement enablement;
	private String username;
	private String password;
	private Group group;
	
	User(){
		
	}
	
	private User(UserId id, FullName fullName, ContactInfo contactInfo, Enablement enablement
			,String username, String password, Group group){
		Validate.notNull(id, "UserId is required.");
		Validate.notNull(fullName, "full name is required");
		Validate.notNull(username, "username is required");
		Validate.notNull(password, "password is required");
		this.id = id;
		this.fullName = fullName;
		this.contactInfo = contactInfo;
		this.enablement = enablement;
		this.username = username;
		this.password = password;
		this.group = group;
	}
	
	public boolean isEnabled(){
		return enablement.isEnabled();
	}
	
	public boolean sameIdentityAs(User other) {
		return this.id.sameValuesAs(other.id);
	}
	
	public void changePassword(String currentPassword, String newPassword){
		// TODO change password;
	}
	
	public void changeContactInfo(ContactInfo newContactInfo){
		// TODO - change contact info
	}
}
