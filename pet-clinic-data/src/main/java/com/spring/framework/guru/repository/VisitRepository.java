package com.spring.framework.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.framework.guru.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
