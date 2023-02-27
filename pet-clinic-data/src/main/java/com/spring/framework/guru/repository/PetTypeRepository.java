package com.spring.framework.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.framework.guru.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
