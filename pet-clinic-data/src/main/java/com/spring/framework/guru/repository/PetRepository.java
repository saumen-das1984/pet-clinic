package com.spring.framework.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.framework.guru.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
