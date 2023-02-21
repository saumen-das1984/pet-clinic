package com.spring.framework.guru.service;

import java.util.Set;

import com.spring.framework.guru.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> finsAll();

}
