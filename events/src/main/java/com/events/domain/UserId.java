package com.events.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class UserId implements Identity<Long>, ValueObject<UserId> {
	private static final long serialVersionUID = 1L;
	private final Long value;
	
	@Override
	public boolean sameValuesAs(UserId other) {
		return this.equals(other);
	}

}
