package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.Validate;
import org.jongo.MongoCollection;

import com.jebhomenye.identityandsecurity.domain.model.web.SecureURL;
import com.jebhomenye.identityandsecurity.domain.model.web.SecureURLRepository;

@Named
public class MongoSecureURLRepository implements SecureURLRepository{
	
	@Inject private JongoProvider jongoProvider;
	
	@Override
	public void add(SecureURL secureURL) {
		Validate.notNull(secureURL, "url to secure cannot be null");
		secureURLs().save(secureURL);
	}

	@Override
	public List<SecureURL> getSecuredURLS() {
		Iterable<SecureURL> iterable = secureURLs().find().as(SecureURL.class);
		
		List<SecureURL> retValue = new ArrayList<>();
		for(SecureURL url : iterable){
			retValue.add(url);
		}
		
		return retValue;
	}
	
	private MongoCollection secureURLs(){
		return jongoProvider.get().getCollection("secure_url");
	}
	

}
