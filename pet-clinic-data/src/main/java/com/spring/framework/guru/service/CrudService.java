package com.spring.framework.guru.service;

import java.util.Set;

public interface CrudService<T, ID> {
	
	Set<T> findAll();
	
	T findById(ID id);
	
	T save (T object);
	
	T delete (T object);
	
	T deleteById(ID id);
}
