package com.spring.framework.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.framework.guru.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
}
