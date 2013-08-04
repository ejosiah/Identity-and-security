package com.jebhomenye.identityandsecurity.infrastructure.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jebhomenye.identityandsecurity.domain.model.user.Enablement;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.Role;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.infrastructure.spring.UserDetailsAssembler;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsAssemblerUTest {
	private static final String USERNAME = "user1@test.com";
	private static final String PASSWORD = "user1xxxx";
	@Mock private IdentityUser user;
	@Mock private Group group;
	@Mock private Role adminRole;
	@Mock private Role userRole;
	@Mock private Enablement userEnablement;
	
	@InjectMocks UserDetailsAssembler userDetailsAssembler;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAssembleFrom() {
		when(user.username()).thenReturn(USERNAME);
		when(user.password()).thenReturn(PASSWORD);
		when(user.group()).thenReturn(group);
		when(user.enablement()).thenReturn(userEnablement);
		when(group.roles()).thenReturn(Arrays.asList(adminRole, userRole));
		when(adminRole.name()).thenReturn("ROLE_ADMIN");
		when(userRole.name()).thenReturn("USER_ROLE");
		when(userEnablement.isEnabled()).thenReturn(true);
		when(userEnablement.timeExpired()).thenReturn(false);
		
		UserDetails expected = expected();
		UserDetails actual = userDetailsAssembler.assembleFrom(user);
		
		assertEquals(expected, actual);
	}
	
	private UserDetails expected(){
		return new org.springframework.security.core.userdetails.User(
				USERNAME, PASSWORD, true, true, true, true, 
				Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")
					   , new SimpleGrantedAuthority("ROLE_USER")));
		
	}

}
