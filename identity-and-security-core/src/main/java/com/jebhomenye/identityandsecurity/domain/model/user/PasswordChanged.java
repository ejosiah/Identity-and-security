package com.jebhomenye.identityandsecurity.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.event.DomainEvent;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Accessors(fluent=true)
public class PasswordChanged extends DomainEvent {
	private static final long serialVersionUID = 1L;
	
	private String currentPassword;
	private String newPassword;

	@Override
	public boolean sameValuesAs(DomainEvent other) {
		return this.sameValuesAs(other);
	}

}
