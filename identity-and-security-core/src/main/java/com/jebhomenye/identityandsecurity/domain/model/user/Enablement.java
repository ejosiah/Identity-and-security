package com.jebhomenye.identityandsecurity.domain.model.user;

import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.NONE)
public class Enablement implements ValueObject<Enablement> {
	public static final Enablement INDEFINATLY_ENABLED = new Enablement(null, null, true);
	
	private DateTime startDate;
	private DateTime endDate;
	
	@Getter(value=AccessLevel.NONE)
	private boolean enabled;
	
	public boolean isEnabled(){
		return enabled && !timeExpired();
	}
	
	public boolean timeExpired(){
		boolean expired = false;
		
		if(startDate != null && endDate != null){
			DateTime now = DateTime.now();
			if(now.isBefore(startDate) || now.isAfter(endDate)){
				expired = true;
			}
		}
		return expired;
	}
	
	public boolean sameValuesAs(Enablement other) {
		return this.equals(other);
	}
	
}
