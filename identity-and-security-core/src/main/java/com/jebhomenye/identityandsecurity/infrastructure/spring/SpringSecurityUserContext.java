package com.jebhomenye.identityandsecurity.infrastructure.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.UserContext;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class SpringSecurityUserContext implements UserContext {
	
	@Inject
	private UserRepository userRepository;

	public IdentityUser currentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String username = authentication.getName();

		return userRepository.userOfUsername(username);
	}

	public void setCurrentUser(IdentityUser user) {
		throw new UnsupportedOperationException("setCurrentUser not Supported");
		
	}

}
