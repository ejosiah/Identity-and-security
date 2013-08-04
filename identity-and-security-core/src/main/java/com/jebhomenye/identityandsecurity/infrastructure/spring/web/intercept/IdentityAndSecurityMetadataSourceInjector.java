package com.jebhomenye.identityandsecurity.infrastructure.spring.web.intercept;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURLRepository;

@Named
public class IdentityAndSecurityMetadataSourceInjector implements BeanPostProcessor {
	
    @Inject private SecureURLRepository secureURLRepository;
    
    @Inject @Named("defaultWebSecurityExpressionHandler")
    private SecurityExpressionHandler<FilterInvocation> expressionHandler;
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof FilterInvocationSecurityMetadataSource){
			return new IdentityAndSecurityMetadataSource(secureURLRepository, expressionHandler);
		}
		return bean;

	}

}
