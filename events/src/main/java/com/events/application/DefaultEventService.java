package com.events.application;

import javax.inject.Inject;
import javax.inject.Named;

import com.events.adapter.UserAdapter;
import com.events.domain.Event;
import com.events.domain.EventId;
import com.events.domain.EventRepository;
import com.events.domain.User;
import com.events.domain.UserId;

@Named
public class DefaultEventService implements EventService{
	
	private EventRepository eventRepository;
	
	@Inject
	private UserAdapter userRepository;

	@Override
	public EventId createEvent(CreateEventCommand createEvent) {
		User user = userRepository.userFor(createEvent.getUsername());
		
		Event event = assembleFrom(createEvent, user.id());
		event = eventRepository.add(event);
		
		return event.id();
	}
	
	public Event assembleFrom(CreateEventCommand createEvent, UserId userId){
		return Event.builder()
				.title(createEvent.getTitle())
				.startTime(createEvent.getStartTime())
				.endTime(createEvent.getEndTime())
				.repeat(createEvent.isRepeat())
				.firstAlert(createEvent.getFirstAlert())
				.secondAlert(createEvent.getSecondAlert())
				.url(createEvent.getUrl())
				.notes(createEvent.getNotes())
				.Location(createEvent.getLocation())
				.userId(userId)
			.build();
	}

	@Override
	public void updateEvent(UpdateEventCommand updateEvent) {
		EventId eventId = new EventId(updateEvent.getEventId());
		Event event = eventRepository.eventOfId(eventId);
		
		
		
	}

}
