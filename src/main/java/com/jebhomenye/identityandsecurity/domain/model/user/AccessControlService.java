package com.jebhomenye.identityandsecurity.domain.model.user;

public interface AccessControlService {
	
	void  creatRole(Role role);
	
	void createGroup(Group group);
	
	Group getGroupByName(String groupName);
	
	Role getRoleByName(String roleName);
}
