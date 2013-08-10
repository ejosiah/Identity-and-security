package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.event.DomainEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent=true)
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(callSuper=true)
public class UserRegistered extends DomainEvent{
	
	private EmailAddress emailAddress;
	private FullName name;
	private UserId userId;
	private String username;

	@Override
	public boolean sameValuesAs(DomainEvent other) {
		return this.equals(other);
	}

}
