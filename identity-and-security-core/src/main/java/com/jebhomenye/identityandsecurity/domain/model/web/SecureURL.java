package com.jebhomenye.identityandsecurity.domain.model.web;

import java.util.Collection;

import lombok.Getter;

@Getter
public class SecureURL {
	private String pattern;
	private Collection<String> configs;
	
	SecureURL(){
		
	}
	
	public SecureURL(String pattern, Collection<String> configs){
		this.pattern = pattern;
		this.configs = configs;
	}
}
