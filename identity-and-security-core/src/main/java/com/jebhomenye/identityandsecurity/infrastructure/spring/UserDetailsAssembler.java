package com.jebhomenye.identityandsecurity.infrastructure.spring;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Named;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jebhomenye.identityandsecurity.domain.model.user.Role;
import com.jebhomenye.identityandsecurity.domain.model.user.User;

@Named
public class UserDetailsAssembler {
	
	public UserDetails assembleFrom(User user){
		return new org.springframework.security.core.userdetails.User(
				user.username() 
				, user.password() 
				, user.isEnabled() 
				, !user.enablement().timeExpired()
				, true
				, true
				, assembleAuthorites(user.group().roles()));
	}

	private Collection<? extends GrantedAuthority> assembleAuthorites(Collection<Role> roles) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for(Role role : roles){
			authorities.add(new SimpleGrantedAuthority(role.value()));
		}
		return authorities;
	}
}
