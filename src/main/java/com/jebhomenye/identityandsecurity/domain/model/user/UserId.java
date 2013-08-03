package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class UserId implements Identity<String>, ValueObject<UserId> {
	private static final long serialVersionUID = 1L;
	private final String value;

	public boolean sameValuesAs(UserId other) {
		return this.equals(other);
	}
}
