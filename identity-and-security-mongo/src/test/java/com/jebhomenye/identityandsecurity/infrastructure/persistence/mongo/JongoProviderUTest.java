package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.jongo.Jongo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.MongoDbFactory;

import com.jebhomenye.identityandsecurity.util.TestUtil;
import com.mongodb.DB;

@RunWith(MockitoJUnitRunner.class)
public class JongoProviderUTest {
	
	@Mock MongoDbFactory mongoDbFactory;
	@Mock DB db;
	@Mock Jongo jongo;
	
	@InjectMocks JongoProvider jongoProvider;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() {
		Jongo expected = jongo;
		Jongo actual = jongoProvider.get();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInit() {
		TestUtil.set("jongo", null, jongoProvider);
		TestUtil.set("database", "test", jongoProvider);
		
		when(mongoDbFactory.getDb("test")).thenReturn(db);
		assertNull(jongoProvider.get());
		
		jongoProvider.init();
		Jongo jongo = jongoProvider.get();
		
		assertEquals(db, jongo.getDatabase());
	}

}
