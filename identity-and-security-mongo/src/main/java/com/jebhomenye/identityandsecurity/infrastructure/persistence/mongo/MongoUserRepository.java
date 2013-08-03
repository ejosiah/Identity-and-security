package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import javax.inject.Inject;
import javax.inject.Named;

import static java.lang.String.*;

import org.apache.commons.lang3.Validate;
import org.jongo.MongoCollection;

import com.jebhomenye.identityandsecurity.domain.model.user.User;
import com.jebhomenye.identityandsecurity.domain.model.user.UserId;
import com.jebhomenye.identityandsecurity.domain.model.user.UserRepository;

@Named
public class MongoUserRepository implements UserRepository{
	
	private static final Class<User> USER = User.class;
	private static final String USER_COLLECTION = USER.getSimpleName().toLowerCase();
	
	@Inject private JongoProvider jongoProvider;
	@Inject private MongoIdGenerator idGenerator;
	
	@Override
	public void add(User user) {
		Validate.notNull(user, "user is required");
		users().save(user);
	}

	@Override
	public User userOfUsername(String username) {
		Validate.notNull(username, "username is required");
		String byUsername = format("{ username : \"%s\"}", username);
		return users().findOne(byUsername).as(USER);
	}

	@Override
	public UserId nextIdentity() {
		return idGenerator.nextId(UserId.class);
	}
	
	private MongoCollection users(){
		return jongoProvider.get().getCollection(USER_COLLECTION);
	}

}
