package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.jongo.Find;
import org.jongo.FindOne;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserId;

@RunWith(MockitoJUnitRunner.class)
public class MongoUserRepositoryUTest {
	private static final UserId USER_ID = new UserId(1L);
	@Mock Jongo jongo;
	@Mock JongoProvider jongoProvider;
	@Mock User user;
	@Mock MongoIdGenerator idGenerator;
	@Mock MongoCollection users;
	@Mock FindOne findOne;
	
	
	@InjectMocks MongoUserRepository mongoUserRepository;
	
	@Before
	public void setUp() throws Exception {
		when(jongoProvider.get()).thenReturn(jongo);
		when(jongo.getCollection("user")).thenReturn(users);
	}

	@Test
	public void testAdd() {
		mongoUserRepository.add(user);
		verify(users).save(user);
	}

	@Test
	public void testUserOfUsername() {
		when(users.findOne("{ username : \"test@example.com\"}")).thenReturn(findOne);
		when(findOne.as(User.class)).thenReturn(user);
		
		User expected = user;
		User actual = mongoUserRepository.userOfUsername("test@example.com");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testNextIdentity() {
		when(idGenerator.nextId(UserId.class)).thenReturn(USER_ID);
		
		UserId expected = USER_ID;
		UserId actual = mongoUserRepository.nextIdentity();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNullUsername(){
		try {
			mongoUserRepository.userOfUsername(null);
		} catch (NullPointerException e) {
			String expected = "username is required";
			String actual = e.getMessage();
			assertEquals(expected, actual);
		}
		
	}
	
	@Test
	public void testNullUser(){
		try {
			mongoUserRepository.add(null);
		} catch (NullPointerException e) {
			String expected = "user is required";
			String actual = e.getMessage();
			assertEquals(expected, actual);
		}
	}

}
