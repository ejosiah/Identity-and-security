package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.jebhomenye.domain.common.core.AggregateRoot;
import com.jebhomenye.domain.common.core.Entity;
import com.jebhomenye.domain.common.event.DomainEventPublisher;
import com.jebhomenye.identityandsecurity.domain.model.DomainRegistry;

@Data
@Accessors(fluent=true)
@EqualsAndHashCode(callSuper=false)
public class User extends AggregateRoot<User, UserId, UserMomento> {
	
	private UserId id;
	private FullName fullName;
	private ContactInfo contactInfo;
	private Enablement enablement;
	private String username;
	private String password;
	private Group group;
	private int version;
	
	User(){
		
	}
	
	public User(FullName fullName, ContactInfo contactInfo
			,String username, String password, String groupName){

		createId();
		apply(new UserRegistered(
						fullName
						, id
						, username
						, DomainRegistry
							.passwordService()
								.encyrpt(password)
						, groupName
						, contactInfo
						, version+1));
	}
	
	public void when(UserRegistered userRegistered){
		fullName(userRegistered.fullName());
		username(userRegistered.username());
		password(userRegistered.password());
		version(userRegistered.version());
		this.contactInfo = userRegistered.contactInfo();
		defaultEnablement();
		group(userRegistered.groupName());
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
		this.password = password;
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
	
	@Override
	public boolean sameIdentityAs(User other) {
		return this.id.sameValuesAs(other.id);
	}
	
	public void changePassword(String currentPassword, String newPassword){
		apply(new PasswordChanged(
				DomainRegistry.passwordService().encyrpt(currentPassword),
				DomainRegistry.passwordService().encyrpt(newPassword)));
	}
	
	public void when(PasswordChanged passwordChanged){
		Validate.isTrue(this.password.equals(passwordChanged.currentPassword())
				, "invalid password");
		password(passwordChanged.newPassword());
	}
	
	public void changeHomeAddress(Address homeAddress){
		// TODO - change contact info
	}
	
	public UserDescriptor UserDescriptor(){
		return new UserDescriptor(id, username, contactInfo.emailAddress().value());
	}
	
	@Override
	public void version(int value){
		version = value;
	}
	
	@Override
	public int version() {
		return version;
	}

	@Override
	public UserMomento takeSnapShot() {
		return new UserMomento(
				id.value()
				, version
				, fullName
				, username
				, password
				, group.name()
				, enablement
				, contactInfo);
	}

	@Override
	public void restoreFrom(UserMomento userMomento) {
		id(new UserId(userMomento.getUserId()));
		version(userMomento.getVersion());
		fullName(userMomento.getFullName());
		username(userMomento.getUsername());
		password(userMomento.getPassword());
		group(userMomento.getGroup());
		enablement(userMomento.getEnablement());
		contactInfo(userMomento.getContactInfo());
	}
}
