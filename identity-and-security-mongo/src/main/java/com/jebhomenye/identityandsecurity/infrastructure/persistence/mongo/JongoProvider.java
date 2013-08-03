package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.jongo.Jongo;
import org.jongo.marshall.jackson.JacksonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mongodb.DB;

@Named
public class JongoProvider implements Provider<Jongo>{
	
	private Jongo jongo;
	
	@Value("mongo.database")
	private String database;
	
	@Inject
	private MongoDbFactory mongoDBFactory;
	
	@PostConstruct
	public void init(){
		DB db = mongoDBFactory.getDb(database);
		jongo = new Jongo(db
				, new JacksonMapper.Builder()
					.registerModule(new JodaModule())
					.build()
		);
	}

	@Override
	public Jongo get() {
		return jongo;
	}

}
