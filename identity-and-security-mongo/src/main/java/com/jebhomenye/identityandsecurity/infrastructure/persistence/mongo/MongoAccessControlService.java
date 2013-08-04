package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.Validate;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.Role;

@Named
public class MongoAccessControlService implements AccessControlService {
	
	@Inject
	private JongoProvider jongoProvider;

	@Override
	public void creatRole(Role role) {
		Validate.notNull(role);
		roles().save(role);
		
	}

	@Override
	public void createGroup(Group group) {
		ensureRole(group.roles());
		groups().save(group);
	}

	private void ensureRole(Collection<Role> roles) {
		for(Role role : roles){
			if(getRoleByName(role.name()) == null){
				creatRole(role);
			}
		}
	}

	@Override
	public Group getGroupByName(String groupName) {
		return groups().findOne("{name : #}", groupName).as(Group.class);
	}

	@Override
	public Role getRoleByName(String roleName) {
		return roles().findOne("{name : #}", roleName).as(Role.class);
	}
	
	private MongoCollection roles(){
		return jongoProvider.get().getCollection("role");
	}
	
	private MongoCollection groups(){
		return jongoProvider.get().getCollection("groups");
	}

}
