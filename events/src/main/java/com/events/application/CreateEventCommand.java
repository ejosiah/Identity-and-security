package com.events.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import org.joda.time.DateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventCommand {
	private String username;
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
