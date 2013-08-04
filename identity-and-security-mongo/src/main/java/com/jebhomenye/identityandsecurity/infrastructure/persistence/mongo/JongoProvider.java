package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.jongo.Jongo;
import org.jongo.marshall.jackson.JacksonMapper;
import org.springframework.data.mongodb.MongoDbFactory;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mongodb.DB;

@Named
public class JongoProvider implements Provider<Jongo>{
	
	private Jongo jongo;
	
	@Inject
	private MongoDbFactory mongoDbFactory;
	
	@PostConstruct
	public void init(){
		DB db = mongoDbFactory.getDb();
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
