package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String...args){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/identity-and-security.mongo.spring.xml");
		JongoProvider provider = context.getBean(JongoProvider.class);
		System.out.println(provider);
	}
}
