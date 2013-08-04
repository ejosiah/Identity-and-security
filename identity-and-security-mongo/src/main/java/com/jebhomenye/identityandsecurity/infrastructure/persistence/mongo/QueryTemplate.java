package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

public interface QueryTemplate {
	
	String NEXT_ID = "{ query : {name : #}, update : {$inc : { nextId : 1 }}, upsert : true, new : true }";
}	
