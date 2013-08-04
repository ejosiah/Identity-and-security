package com.events.domain;

import java.util.Collection;

public interface EventRepository {
	
	Event add(Event event);
	
	void eventOfTitle(String title);
	
	Collection<Event> events();

	Event eventOfId(EventId eventId);
}
