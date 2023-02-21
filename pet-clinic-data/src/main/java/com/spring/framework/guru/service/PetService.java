package com.spring.framework.guru.service;

import java.util.Set;

import com.spring.framework.guru.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> finsAll();

}
