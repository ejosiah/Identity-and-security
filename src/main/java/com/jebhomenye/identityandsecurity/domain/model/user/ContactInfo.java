package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Value;

import com.jebhomenye.domain.common.core.ValueObject;

@Value
public class ContactInfo implements ValueObject<ContactInfo> {
	private EmailAddress emailAddress;
	private Address homeAddress;
	private Address billingAddress;
	private Telephone primaryTelephone;
	private Telephone secondaryTelephone;
	
	public boolean sameValuesAs(ContactInfo other) {
		return this.equals(other);
	}
	
	
}
