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
public class ContactInfoChanged extends DomainEvent {
	
	private UserId userId;
	private String username;
	private ContactInfo contactInfo;

	@Override
	public boolean sameValuesAs(DomainEvent other) {
		return this.equals(other);
	}

}
