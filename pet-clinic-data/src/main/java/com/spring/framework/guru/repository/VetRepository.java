package com.spring.framework.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.framework.guru.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
