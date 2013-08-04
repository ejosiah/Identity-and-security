package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURL;

@RunWith(MockitoJUnitRunner.class)
public class MongoSecureURLRepositoryUTest {
	
	@Mock JongoProvider provider;
	@Mock Jongo jongo;
	@Mock MongoCollection collection;
	@Mock Find find;
	@Mock SecureURL secureURL;
	@Mock Collection<SecureURL> securedURLs;
	@Mock Iterable<SecureURL> Iterable;
	
	@InjectMocks MongoSecureURLRepository secureURLRepository;
	
	@Before
	public void setUp() throws Exception {
		when(provider.get()).thenReturn(jongo);
		when(jongo.getCollection("secure_url")).thenReturn(collection);
	}

	@Test
	public void testAdd() {
		secureURLRepository.add(secureURL);
		verify(collection).save(secureURL);
	}
	
	@Test
	public void testListAll(){
		when(collection.find()).thenReturn(find);
		when(find.as(SecureURL.class)).thenReturn(Iterable);
		when(Iterable.iterator()).thenReturn(Arrays.asList(secureURL).iterator());
		
		List<SecureURL> secured = secureURLRepository.getSecuredURLS();
		assertNotNull(secured);
		assertEquals(1, secured.size());
		assertEquals(secureURL, secured.get(0));
	}

}
