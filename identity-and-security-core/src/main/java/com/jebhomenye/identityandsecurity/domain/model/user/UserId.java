package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@AllArgsConstructor
public class UserId implements Identity<Long>, ValueObject<UserId> {
	private static final long serialVersionUID = 1L;
	private final Long value;
	
	UserId(){
		value = null;
	}
	
	public boolean sameValuesAs(UserId other) {
		return this.equals(other);
	}
}
