package com.jebhomenye.identityandsecurity.domain.model.user;

import org.apache.commons.lang3.Validate;

import com.jebhomenye.domain.common.core.ValueObject;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent=true)
public class EmailAddress implements ValueObject<EmailAddress> {
	private static final String EMAIL_PATTERN = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	private final String value;
	
	public EmailAddress(String value){
		Validate.notNull(value, "Email address is required");
		Validate.matchesPattern(value, EMAIL_PATTERN, "Email address format is invalid");
		this.value = value;
	}
	
	public boolean sameValuesAs(EmailAddress other) {
		return this.equals(other);
	}
	
}
