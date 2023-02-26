package com.spring.framework.guru.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	private Set<Speciality> specialities = new HashSet<>();

}
