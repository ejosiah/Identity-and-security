package com.jebhomenye.identityandsecurity.domain.model;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.experimental.Accessors;

import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.PasswordService;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Accessors(fluent=true)
public class DomainRegistry {
	private static DomainRegistry domainRegistry;
	
	private DomainRegistry(){
		
	}
	
	
	public static DomainRegistry instance(){
		if(domainRegistry == null){
			domainRegistry = new DomainRegistry();
		}
		return domainRegistry;
	}
	
	@Inject private PasswordService passwordService;
	@Inject private AccessControlService accessControlService;
	@Inject private UserRepository userRepository;
	
	public static PasswordService passwordService(){
		return domainRegistry.passwordService;
	}
	
	public static UserRepository uesrRepository(){
		return domainRegistry.userRepository;
	}
	
	public static AccessControlService accessControlService(){
		return domainRegistry.accessControlService;
	}
	
	
}
