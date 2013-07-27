package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.IdentifiableValueObject;

@Data
@Accessors(fluent=true)
public class Role implements IdentifiableValueObject<Role, String> {
	private final String id;
	private final String value;

	public boolean sameValuesAs(Role other) {
		return this.sameValuesAs(other);
	}

}
