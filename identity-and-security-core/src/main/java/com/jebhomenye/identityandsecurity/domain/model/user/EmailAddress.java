package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.apache.commons.lang3.Validate;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@NoArgsConstructor
@Setter(AccessLevel.NONE)
public class EmailAddress implements ValueObject<EmailAddress> {
	private static final String EMAIL_PATTERN = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	private String value;
	
	public EmailAddress(String value){
		Validate.notNull(value, "Email address is required");
		Validate.matchesPattern(value, EMAIL_PATTERN, "Email address format is invalid");
		this.value = value;
	}
	
	public boolean sameValuesAs(EmailAddress other) {
		return this.equals(other);
	}
	
}
