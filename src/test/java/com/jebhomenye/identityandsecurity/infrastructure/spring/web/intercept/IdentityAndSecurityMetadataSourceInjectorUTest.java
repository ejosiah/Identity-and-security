package com.jebhomenye.identityandsecurity.infrastructure.spring.web.intercept;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

@RunWith(MockitoJUnitRunner.class)
public class IdentityAndSecurityMetadataSourceInjectorUTest {
	
	@Mock IdentityAndSecurityMetadataSource metadataSource;
	@Mock FilterInvocationSecurityMetadataSource realMetadataSource;
	
	@InjectMocks IdentityAndSecurityMetadataSourceInjector identityAndSecurityMetadataSourceInjector;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPostProcessAfterInitialization() {
		Object someBean = new Object();
		Object expected = someBean;
		Object actual = identityAndSecurityMetadataSourceInjector
				.postProcessAfterInitialization(someBean, "someBean");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPostProcessBeforeInitialization() {
		Object expected = metadataSource;
		Object actual = identityAndSecurityMetadataSourceInjector
				.postProcessBeforeInitialization(
						realMetadataSource
						, "filterInvocationSecurityMetadataSource");
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testPostProcessBeforeInitializationNotFilterInvocationSecurityMetadataSource(){
		Object someBean = new Object();
		Object expected = someBean;
		Object actual = identityAndSecurityMetadataSourceInjector
				.postProcessBeforeInitialization(someBean, "someBean");
		
		assertEquals(expected, actual);
	}

}
