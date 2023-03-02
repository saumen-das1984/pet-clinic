package com.spring.framework.guru.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.framework.guru.model.PetType;
import com.spring.framework.guru.service.PetTypeService;

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType petType) {
		return super.save(petType);
	}

	@Override
	public void delete(PetType petType) {
		super.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
