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
import com.jebhomenye.identityandsecurity.application.UserAssembler;
import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Address;
import com.jebhomenye.identityandsecurity.domain.model.user.ContactInfo;
import com.jebhomenye.identityandsecurity.domain.model.user.EmailAddress;
import com.jebhomenye.identityandsecurity.domain.model.user.FullName;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.PasswordService;
import com.jebhomenye.identityandsecurity.domain.model.user.Telephone;
import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserId;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserAssemblerUTest {
	private static final UserId USER_ID = new UserId(1L);
	private static final String PASSWORD = "user1983";
	
	@Mock private UserRepository userRepository;
	@Mock private PasswordService passwordService;
	@Mock RegisterUserCommand registerUserCommand;
	@Mock AccessControlService accessControlService;
	@Mock Group group;
	@Mock Address address;
	@Mock Telephone primaryTelephone;
	@Mock Telephone secondaryTelephone;
	@Mock EmailAddress emailAddress;
	
	@InjectMocks private UserAssembler userAssembler;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAssembleFrom() {
		when(userRepository.nextIdentity()).thenReturn(USER_ID);
		when(passwordService.encyrpt(PASSWORD)).thenReturn("userxxxx");
		when(accessControlService.getGroupByName("testGroup")).thenReturn(group);
		
		when(registerUserCommand.getUsername()).thenReturn("user1@test.com");
		when(registerUserCommand.getPassword()).thenReturn(PASSWORD);
		when(registerUserCommand.getFirstname()).thenReturn("Josiah");
		when(registerUserCommand.getLastname()).thenReturn("Ebhomenye");
		when(registerUserCommand.emailAddress()).thenReturn(emailAddress);
		when(registerUserCommand.address()).thenReturn(address);
		when(registerUserCommand.primaryTelephone()).thenReturn(primaryTelephone);
		when(registerUserCommand.secondaryTelephone()).thenReturn(secondaryTelephone);
		when(registerUserCommand.getGroup()).thenReturn("testGroup");
		
		User expected = expected();
		User actual = userAssembler.assembleFrom(registerUserCommand);
		
		assertEquals(expected, actual);
	}
	
	public User expected(){
		User.UserBuilder builder = User.builder();
		return 
			builder
				.username("user1@test.com")
				.password("userxxxx")
				.id(USER_ID)
				.fullName(new FullName("Josiah", "Ebhomenye"))
				.contactInfo(new ContactInfo(
						emailAddress
						, address
						, null
						, primaryTelephone
						, secondaryTelephone))
				.group(group)
			.build();
			
	}

}
