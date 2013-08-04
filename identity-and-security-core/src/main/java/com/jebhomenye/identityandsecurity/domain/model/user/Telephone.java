package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.apache.commons.lang3.Validate;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@NoArgsConstructor
public class Telephone implements ValueObject<Telephone> {
	private static final String TELEPHONE_PATTERN = "((\\(\\d{3}\\))|(\\d{3}-))\\d{3}-\\d{5}";
	private String value;
	
	public Telephone(String value){
		Validate.notNull(value, "Telephone number is required");
		Validate.isTrue(value.length() >= 5 && value.length() <= 20, "Telephone number may not be more than 20 characters.");
		Validate.matchesPattern(value, TELEPHONE_PATTERN, "Telephone format invalid");
		this.value = value;
	}
	
	public boolean sameValuesAs(Telephone other) {
		return this.equals(other);
	}

}
