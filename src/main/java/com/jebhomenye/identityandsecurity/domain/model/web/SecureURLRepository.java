package com.jebhomenye.identityandsecurity.domain.model.web;

import java.util.List;

public interface SecureURLRepository {
	
	void add(SecureURL secureURL);
	
	List<SecureURL> getSecuredURLS();
}
