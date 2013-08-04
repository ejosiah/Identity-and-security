package com.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;

@Data
@Accessors(fluent=true)
@AllArgsConstructor
public class EventId implements Identity<Long> {

	private static final long serialVersionUID = 1L;
	private final Long value;
	
	EventId(){
		value = null;
	}
}
