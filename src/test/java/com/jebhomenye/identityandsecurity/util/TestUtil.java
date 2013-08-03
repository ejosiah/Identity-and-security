package com.jebhomenye.identityandsecurity.util;

import java.lang.reflect.Field;

import lombok.SneakyThrows;

public final class TestUtil {
	
	private TestUtil(){}
	
	@SneakyThrows
	public static void set(String field, Object as, Object onThis){
		Field afield = onThis.getClass().getDeclaredField(field);
		afield.setAccessible(true);
		afield.set(onThis, as);
	}
}
