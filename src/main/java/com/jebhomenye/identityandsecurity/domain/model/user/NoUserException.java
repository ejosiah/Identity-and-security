package com.jebhomenye.identityandsecurity.domain.model.user;

public class NoUserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoUserException(String username){
		super("can't find user " + username );
	}

}
