package com.spring.framework.guru.service;

import java.util.Set;

import com.spring.framework.guru.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> finsAll();

}
