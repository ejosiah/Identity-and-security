package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import java.lang.reflect.Constructor;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.SneakyThrows;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

@Named
public class MongoIdGenerator  {
		
	@Inject
	private JongoProvider jongoProvider;
	
	public <T> T nextId(Class<T> forType){
		String name = name(forType);
		IdResult result = ids().findAndModify("{name : #}", name)
							.with("{$inc : {nextId : 1}}")
							.upsert()
							.returnNew()
						.as(IdResult.class);
		
		return createId(forType, result.nextId);
		
	}
	
	private String name(Class<?> clzz){
		String name = clzz.getSimpleName();
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}
	
	private MongoCollection ids(){
		return jongoProvider.get().getCollection("ids");
	}
	
	@SneakyThrows
	private <T> T createId(Class<T> forType, Long id){
		Constructor<T> constructor = forType.getDeclaredConstructor(Long.class);
		return (T)constructor.newInstance(id);
	}
	
	private static class IdResult{
		private Long nextId;
		
	}

}
