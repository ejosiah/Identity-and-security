package com.jebhomenye.identityandsecurity.infrastructure.spring;

import java.util.Collection;

import javax.inject.Named;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURLRepository;


@Named
public class FilterInvocationServiceSecurityMetadataStore implements FilterInvocationSecurityMetadataSource, InitializingBean {
	
    private FilterInvocationSecurityMetadataSource delegate;
    private SecureURLRepository secureURLRepository;
    private SecurityExpressionHandler<FilterInvocation> expressionHandler;
	
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<ConfigAttribute> getAttributes(Object arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
