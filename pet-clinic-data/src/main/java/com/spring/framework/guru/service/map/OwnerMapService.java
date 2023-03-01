package com.spring.framework.guru.service.map;

import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.model.Pet;
import com.spring.framework.guru.service.OwnerService;
import com.spring.framework.guru.service.PetService;
import com.spring.framework.guru.service.PetTypeService;

@Primary
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner) {

		if (owner != null) {
			if (owner.getPets() != null) {
				owner.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required");
					}

					if (pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(owner);
		} else {
			return null;
		}
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

}
