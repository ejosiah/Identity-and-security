package com.events.application;

import com.events.domain.EventId;

public interface EventService {
	
	EventId createEvent(CreateEventCommand createEvent);
	
	void updateEvent(UpdateEventCommand updateEvent);

}
