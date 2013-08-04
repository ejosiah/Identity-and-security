package com.jebhomenye.identityandsecurity.domain.model.user;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.IdentifiableValueObject;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class Group implements ValueObject<Group> {
	private final Collection<Role> roles;
	private final String name;
	
	Group(){
		roles = null;
		name = null;
	}
	
	public Group(String name, Collection<Role> roles){
		this.name = name;
		this.roles = new HashSet<Role>(roles);
	}

	public Group(String name, Role role) {
		this(name, Collections.singleton(role));
	}

	public boolean sameValuesAs(Group other) {
		return this.equals(other);
	}


}
