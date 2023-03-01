package com.spring.framework.guru.service.map;

import java.util.Set;

import com.spring.framework.guru.model.Visit;
import com.spring.framework.guru.service.VisitService;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if( null == visit.getPet() || null == visit.getPet().getOwner() ||
				 null == visit.getPet().getId() || null == visit.getPet().getOwner().getId()) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(visit);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
