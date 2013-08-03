package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import java.lang.reflect.Constructor;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.SneakyThrows;

import org.jongo.MongoCollection;

@Named
public class MongoIdGenerator  {
		
	@Inject
	private JongoProvider jongoProvider;
	
	public <T> T nextId(Class<T> forType){
		String name = name(forType);
		String query = String.format(QueryTemplate.NEXT_ID, name);
		Long id = ids().findAndModify(query).projection("nextId").as(Long.class);
		
		return createId(forType, id);
		
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
}
