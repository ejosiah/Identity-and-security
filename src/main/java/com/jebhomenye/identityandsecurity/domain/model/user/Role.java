package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.IdentifiableValueObject;

@Value
@Accessors(fluent=true)
public class Role implements IdentifiableValueObject<Role, String> {
	private String id;
	private String value;

	public boolean sameValuesAs(Role other) {
		return this.sameValuesAs(other);
	}

}
