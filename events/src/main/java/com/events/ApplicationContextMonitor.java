package com.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationContextMonitor implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.getClass().getSimpleName() + ": " + event);
		
	}

}
