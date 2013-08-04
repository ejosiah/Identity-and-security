package com.jebhomenye.identityandsecurity.infrastructure.spring.web.intercept;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURL;
import com.jebhomenye.identityandsecurity.domain.model.web.SecureURLRepository;


public class IdentityAndSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
	
    private SecureURLRepository secureURLRepository;
    private SecurityExpressionHandler<FilterInvocation> expressionHandler;
    
    public IdentityAndSecurityMetadataSource(SecureURLRepository secureURLRepository, SecurityExpressionHandler<FilterInvocation> expressionHandler){
    	this.secureURLRepository = secureURLRepository;
    	this.expressionHandler = expressionHandler;
    }
    
    private FilterInvocationSecurityMetadataSource delegate;
	
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return delegate.getAllConfigAttributes();
	}

	public Collection<ConfigAttribute> getAttributes(Object object) {
		return delegate.getAttributes(object);
	}

	public boolean supports(Class<?> clazz) {
		return delegate.supports(clazz);
	}

	public void afterPropertiesSet() throws Exception {
		List<SecureURL> securedURLs = secureURLRepository.getSecuredURLS();
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();
		
		for(SecureURL secureURL : securedURLs){
			RequestMatcher matcher = new AntPathRequestMatcher(secureURL.getPattern());
			requestMap.put(matcher, configAttributes(secureURL.getConfigs()));
		}
		
		delegate = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);
		
	}
	
	private Collection<ConfigAttribute> configAttributes(Collection<String> configs){
		LinkedList<ConfigAttribute> attributes = new LinkedList<>();
		for(String config : configs){
			attributes.add(new SecurityConfig(config));
		}
		return attributes;
	}
	
	FilterInvocationSecurityMetadataSource delegate(){
		return delegate;
	}

}
