package com.spring.framework.guru.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;

}
