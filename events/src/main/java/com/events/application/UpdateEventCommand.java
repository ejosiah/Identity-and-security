package com.events.application;

import lombok.Data;

import org.joda.time.DateTime;

@Data
public class UpdateEventCommand {
	private Long eventId;
	private String title;
	private DateTime startTime;
	private DateTime endTime;
	private boolean repeat;
	private Long firstAlert;
	private Long secondAlert;
	private String url;
	private String notes;
	private String Location;
}
