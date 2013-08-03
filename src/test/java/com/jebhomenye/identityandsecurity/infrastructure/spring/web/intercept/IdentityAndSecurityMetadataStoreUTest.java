package com.jebhomenye.identityandsecurity.infrastructure.spring.web.intercept;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURL;
import com.jebhomenye.identityandsecurity.domain.model.web.SecureURLRepository;
import com.jebhomenye.identityandsecurity.util.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class IdentityAndSecurityMetadataStoreUTest {
	
	@Mock SecureURLRepository secureURLRepository;
	@Mock SecurityExpressionHandler<FilterInvocation> expressionHandler;
	@Mock FilterInvocationSecurityMetadataSource delegate;
	@Mock ConfigAttribute configAttribute;
	@Mock Collection<ConfigAttribute> configAttributes;
	@Mock List<SecureURL> securedURLs;
	
	@InjectMocks IdentityAndSecurityMetadataSource metadataSource;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllConfigAttributes() {
		when(delegate.getAllConfigAttributes()).thenReturn(configAttributes);
		Collection<ConfigAttribute> expected = configAttributes;
		
		Collection<ConfigAttribute> actual = metadataSource.getAllConfigAttributes();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAttributes() {
		String key = "/home";
		when(delegate.getAttributes(key)).thenReturn(configAttributes);
		Collection<ConfigAttribute> expected = configAttributes;
		Collection<ConfigAttribute> actual = metadataSource.getAttributes(key);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSupports() {
		when(delegate.supports(Object.class)).thenReturn(true);
		assertTrue(metadataSource.supports(Object.class));
	}

	@Test
	public void testAfterPropertiesSet() throws Exception {
		TestUtil.set("delegate", null, metadataSource);
		TestUtil.set("expressionHandler", new DefaultWebSecurityExpressionHandler(), metadataSource);
		when(secureURLRepository.getSecuredURLS()).thenReturn(securedURLs);
		when(securedURLs.iterator()).thenReturn(
				new ArrayList<SecureURL>().iterator());
		assertNull(metadataSource.delegate());
		
		metadataSource.afterPropertiesSet();
		
		assertNotNull(metadataSource.delegate());
		assertTrue(metadataSource.delegate()
				instanceof 
				 ExpressionBasedFilterInvocationSecurityMetadataSource);
	}

}
