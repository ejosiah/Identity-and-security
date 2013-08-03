package com.jebhomenye.identityandsecurity.infrastructure.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;
import com.jebhomenye.identityandsecurity.infrastructure.spring.SpringSecurityUserContext;

@RunWith(MockitoJUnitRunner.class)
public class SpringSecurityUserContextUTest {
	private static final String USER_NAME = "user1@example.com";
	
	@Mock SecurityContext securityContext;
	@Mock Authentication authentication;
	@Mock UserRepository userRepository;
	@Mock User user;
	
	@InjectMocks
	SpringSecurityUserContext userContext;
	
	@Before
	public void setUp() throws Exception {
		SecurityContextHolder.setContext(securityContext);
	}
	
	@After
	public void tearDown() throws Exception{
		SecurityContextHolder.clearContext();
	}

	@Test
	public void test() {
		when(securityContext.getAuthentication()).thenReturn(authentication);
		when(authentication.getName()).thenReturn(USER_NAME);
		when(userRepository.userOfUsername(USER_NAME)).thenReturn(user);
		
		User expected = user;
		User actual = userContext.currentUser();
		
		assertEquals(expected, actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testSetCurrentUser(){
		userContext.setCurrentUser(user);
	}

}
