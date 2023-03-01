package com.spring.framework.guru.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.framework.guru.model.PetType;
import com.spring.framework.guru.repository.PetTypeRepository;
import com.spring.framework.guru.service.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public void delete(PetType petType) {
		petTypeRepository.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
