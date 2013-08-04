package com.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent=true)
public class User implements Entity<User, UserId>{
	private UserId id;
	private String username;
	
	@Override
	public boolean sameIdentityAs(User other) {
		return this.id.equals(other.id);
	}
}
