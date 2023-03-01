package com.spring.framework.guru.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.repository.OwnerRepository;
import com.spring.framework.guru.repository.PetRepository;
import com.spring.framework.guru.repository.PetTypeRepository;
import com.spring.framework.guru.service.OwnerService;

@Service
public class OwnerSDJpaService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners :: add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
