package com.events;

import org.bson.types.ObjectId;

public class ID {
	private ObjectId _id;
	private String name;
	
	@Override
	public String toString(){
		return String.format("{name : %s}",  name);
	}
}
