package com.jebhomenye.identityandsecurity.infrastructure.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jebhomenye.identityandsecurity.domain.model.user.NoUserException;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;
import com.jebhomenye.identityandsecurity.infrastructure.spring.UserDetailAdaptor;
import com.jebhomenye.identityandsecurity.infrastructure.spring.UserDetailsAssembler;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailAdaptorUTest {
	private static final String USERNAME = "user1@test.com";
	@Mock private UserRepository userRepository;
	@Mock private UserDetailsAssembler userDetailsAssembler;
	@Mock private UserDetails userDetails;
	@Mock private IdentityUser user;
	
	@InjectMocks private UserDetailAdaptor userDetailsAdaptor;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLoadUserByUsername() {
		when(userRepository.userOfUsername(USERNAME)).thenReturn(user);
		when(userDetailsAssembler.assembleFrom(user)).thenReturn(userDetails);
		
		UserDetails expected = userDetails;
		UserDetails actual = userDetailsAdaptor.loadUserByUsername(USERNAME);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected=UsernameNotFoundException.class)
	public void userNotFound(){
		when(userRepository.userOfUsername(USERNAME)).thenThrow(new NoUserException(USERNAME));
		userDetailsAdaptor.loadUserByUsername(USERNAME);
	}

}
