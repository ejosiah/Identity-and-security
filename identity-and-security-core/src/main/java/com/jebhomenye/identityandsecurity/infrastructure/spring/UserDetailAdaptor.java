package com.jebhomenye.identityandsecurity.infrastructure.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jebhomenye.identityandsecurity.domain.model.user.NoUserException;
import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class UserDetailAdaptor implements UserDetailsService{
	
	@Inject private UserRepository userRepository;
	@Inject UserDetailsAssembler userDetailsAssembler;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUser(username);
		return userDetailsAssembler.assembleFrom(user);
	}
	
	private User getUser(String username){
		try{
			return userRepository.userOfUsername(username);
		}catch(NoUserException e){
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

}
