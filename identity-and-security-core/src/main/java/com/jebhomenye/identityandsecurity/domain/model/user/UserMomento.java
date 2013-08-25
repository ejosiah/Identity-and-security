package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.jebhomenye.domain.common.core.Momento;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMomento implements Momento {
	private Long userId;
	private int version;
	
	private FullName fullName;
	
	private String username;
	private String password;
	private String group;
	
	private Enablement enablement;
	
	private ContactInfo contactInfo;
}
