package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.NONE)
@Accessors(fluent=true)
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
