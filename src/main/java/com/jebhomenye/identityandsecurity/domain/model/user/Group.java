package com.jebhomenye.identityandsecurity.domain.model.user;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.IdentifiableValueObject;

@Data
@Accessors(fluent=true)
public class Group implements IdentifiableValueObject<Group, String> {
	private final Set<Role> roles;
	private final String name;
	
	public Group(String name, Set<Role> roles){
		this.name = name;
		this.roles = new HashSet<Role>(roles);
	}

	public boolean sameValuesAs(Group other) {
		return false;
	}

	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

}
