package com.jebhomenye.identityandsecurity.infrastructure.persistence.mongo;

import javax.inject.Named;

import com.jebhomenye.identityandsecurity.domain.model.user.AccessControlService;
import com.jebhomenye.identityandsecurity.domain.model.user.Group;
import com.jebhomenye.identityandsecurity.domain.model.user.Role;

@Named
public class MongoAccessControlService implements AccessControlService {

	@Override
	public void creatRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group getGroupByName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getRoleByName(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

}
