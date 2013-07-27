package com.jebhomenye.identityandsecurity.infrastructure.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jebhomenye.identityandsecurity.domain.model.user.PasswordEncryptionService;

@Named
public class SpringPasswordEncryptionService implements PasswordEncryptionService{
	
	@Inject
	private PasswordEncoder passwordEncoder;

	public String encyrpt(String password) {
		return passwordEncoder.encode(password);
	}
	
	
}
