package com.events.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import org.joda.time.DateTime;

import com.jebhomenye.domain.common.core.Entity;

@Data
@Builder
@Accessors(fluent=true)
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class Event implements Entity<Event, EventId>{
	
	@Setter(value=AccessLevel.NONE)
	private EventId id;
	private String title;
	private DateTime startTime;
	private DateTime endTime;
	private boolean repeat;
	private Long firstAlert;
	private Long secondAlert;
	private String url;
	private String notes;
	private String Location;
	private UserId userId;
	
	@Override
	public boolean sameIdentityAs(Event other) {
		return this.id.equals(other.id);
	}
	
	
}
