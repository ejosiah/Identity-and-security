package com.jebhomenye.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="table")
public class ORMUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	Long id;
}
