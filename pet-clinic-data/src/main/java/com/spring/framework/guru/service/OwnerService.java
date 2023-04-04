package com.spring.framework.guru.service;

import java.util.List;

import com.spring.framework.guru.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);

}
