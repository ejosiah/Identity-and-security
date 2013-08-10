package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.jebhomenye.domain.common.core.Entity;
import com.jebhomenye.domain.common.event.DomainEventPublisher;
import com.jebhomenye.identityandsecurity.domain.model.DomainRegistry;

@Data
@Accessors(fluent=true)
public class User implements Entity<User, UserId> {
	
	private UserId id;
	private FullName fullName;
	private ContactInfo contactInfo;
	private Enablement enablement;
	private String username;
	private String password;
	private Group group;
	
	User(){
		
	}
	
	public User(FullName fullName, ContactInfo contactInfo
			,String username, String password, String groupName){
		createId();
		fullName(fullName);
		username(username);
		password(password);
		this.contactInfo = contactInfo;
		defaultEnablement();
		group(groupName);
		
		DomainEventPublisher
			.instance()
			.publish(new UserRegistered(
					contactInfo.emailAddress(),
					fullName,
					id,
					username));
	}
	
	private void defaultEnablement() {
		enablement = 
				new Enablement(
						DateTime.now()
						, DateTime.now()
							.plusYears(1)
						, true);
	}

	private void createId() {
		id = DomainRegistry
				.uesrRepository()
					.nextIdentity();
		
	}

	private void fullName(FullName fullName){
		Validate.notNull(fullName, "full name is required");
		this.fullName = fullName;
	}
	
	private void username(String username){
		Validate.notNull(username, "username is required");
		Validate.isTrue(
				!DomainRegistry
					.uesrRepository()
						.userExist(username)
					, "username already exist in system");
		this.username = username;
	}
	
	private void password(String password){
		Validate.notNull(password, "password is required");
		this.password = DomainRegistry
							.passwordService()
								.encyrpt(password);
	}
	
	private void group(String userGroup){
		Group group = DomainRegistry
						.accessControlService()
							.getGroupByName(userGroup);
		
		if(group == null){
			throw new IllegalArgumentException("Invalid group " + userGroup);
		}
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
	
	public UserDescriptor UserDescriptor(){
		return new UserDescriptor(id, username, contactInfo.emailAddress().value());
	}
}
