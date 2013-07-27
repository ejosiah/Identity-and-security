package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Wither
@Accessors(fluent=true)
public class FullName implements ValueObject<FullName> {
	private final String firstname;
	private final String lastname;
	
	public FullName(String firstname, String lastname){
		Validate.notNull(firstname, "Firstname is requred.");
		Validate.notNull(lastname, "Lastname is required,");
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public boolean sameValuesAs(FullName other) {
		return this.equals(other);
	}
}
