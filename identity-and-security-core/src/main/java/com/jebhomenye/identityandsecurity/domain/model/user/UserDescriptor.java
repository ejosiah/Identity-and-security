package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Data;

import org.apache.commons.lang3.Validate;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
public class UserDescriptor implements ValueObject<UserDescriptor> {
	
	private final UserId userId;
	private final String username;
	private final String emailAddress;
	
	public UserDescriptor(UserId userId, String username, String emailAddress){
		Validate.notNull(userId, "userid cannot be null");
		Validate.notNull(username, "username cannont be null");
		Validate.notNull(emailAddress, "Email address cannot be null");
		
		this.userId = userId;
		this.username = username;
		this.emailAddress = emailAddress;
	}
	
	@Override
	public boolean sameValuesAs(UserDescriptor other) {
		return this.equals(other);
	}

}
