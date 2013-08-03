package com.jebhomenye.identityandsecurity.infrastructure.spring.web.intercept;

import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

@Named
public class IdentityAndSecurityMetadataSourceInjector implements BeanPostProcessor {
	
	IdentityAndSecurityMetadataSource metadataSource;
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof FilterInvocationSecurityMetadataSource){
			return metadataSource;
		}
		return bean;

	}

}
