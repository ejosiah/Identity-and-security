package com.jebhomenye.identityandsecurity.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.identityandsecurity.application.RegisterUserCommand;
import com.jebhomenye.identityandsecurity.application.RegistratoinService;
import com.jebhomenye.identityandsecurity.application.UserAssembler;
import com.jebhomenye.identityandsecurity.domain.model.user.IdentityUser;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class RegistratoinServiceUTest {
	
	@Mock private UserRepository userRepository;
	@Mock private UserAssembler userAssembler;
	@Mock private RegisterUserCommand registerUser;
	@Mock private IdentityUser user;
	
	@InjectMocks private RegistratoinService registrationService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegisterUser() {
		when(userAssembler.assembleFrom(registerUser)).thenReturn(user);
		
		registrationService.registerUser(registerUser);
		verify(userRepository).add(user);
	}

}
