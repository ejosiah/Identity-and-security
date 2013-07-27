package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Value
@Accessors(fluent=true)
public class Address implements ValueObject<Address> {
	private final String street;
	private final String postcode;
	private final String city;
	private final String Country;
	
	public boolean sameValuesAs(Address other) {
		return this.equals(other);
	}	

}