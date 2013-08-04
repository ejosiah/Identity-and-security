package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.IdentifiableValueObject;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@AllArgsConstructor
public class Role implements ValueObject<Role> {
	private final String name;
	
	Role(){
		name = null;
	}
	public boolean sameValuesAs(Role other) {
		return this.sameValuesAs(other);
	}

}
