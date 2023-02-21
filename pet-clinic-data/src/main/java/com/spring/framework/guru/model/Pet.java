package com.spring.framework.guru.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pet extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;

}
