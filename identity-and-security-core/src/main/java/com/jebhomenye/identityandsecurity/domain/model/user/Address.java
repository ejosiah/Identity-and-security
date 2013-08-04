package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Setter(AccessLevel.NONE)
public class Address implements ValueObject<Address> {
	private String street;
	private String postcode;
	private String city;
	private String Country;
	
	public boolean sameValuesAs(Address other) {
		return this.equals(other);
	}	

}
