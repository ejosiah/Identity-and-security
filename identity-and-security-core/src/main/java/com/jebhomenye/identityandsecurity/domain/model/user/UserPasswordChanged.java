package com.jebhomenye.identityandsecurity.domain.model.user;

import com.jebhomenye.domain.common.event.DomainEvent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent=true)
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(callSuper=true)
public class UserPasswordChanged extends DomainEvent{
	
	private UserId userId;
	private String username;
	
	@Override
	public boolean sameValuesAs(DomainEvent other) {
		return this.equals(other);
	}
	
}
