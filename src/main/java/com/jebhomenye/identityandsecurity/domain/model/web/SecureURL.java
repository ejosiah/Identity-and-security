package com.jebhomenye.identityandsecurity.domain.model.web;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import com.jebhomenye.identityandsecurity.domain.model.user.Role;

@Getter
public class SecureURL {
	private String pattern;
	private List<Role> access = new ArrayList<Role>();
	
	SecureURL(){
		
	}
	
	public SecureURL(String pattern){
		this.pattern = pattern;
	}
	
	public void addRole(Role role){
		access.add(role);
	}

}
