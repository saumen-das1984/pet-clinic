package com.spring.framework.guru.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.framework.guru.model.Speciality;
import com.spring.framework.guru.service.SpecialityService;

@Service
public class SpecialityMapService extends  AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality speciality) {
		return super.save(speciality);
	}

	@Override
	public void delete(Speciality speciality) {
		super.delete(speciality);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
