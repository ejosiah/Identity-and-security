package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.jongo.FindAndModify;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.identityandsecurity.domain.model.user.UserId;

@RunWith(MockitoJUnitRunner.class)
public class MongoIdGeneratorUTest {
	
	@Mock JongoProvider provider;
	@Mock Jongo jongo;
	@Mock MongoCollection collection;
	@Mock FindAndModify findAndModify;
	
	@InjectMocks MongoIdGenerator idGenerator;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNextId() {
		String query = String.format(QueryTemplate.NEXT_ID, "userId");
		when(provider.get()).thenReturn(jongo);
		when(jongo.getCollection("ids")).thenReturn(collection);
		when(collection.findAndModify(query)).thenReturn(findAndModify);
		when(findAndModify.projection("nextId")).thenReturn(findAndModify);
		when(findAndModify.as(Long.class)).thenReturn(1L);
		
		UserId expected = new UserId(1L);
		UserId actual = idGenerator.nextId(UserId.class);
		
		assertEquals(expected, actual);
	}

}
