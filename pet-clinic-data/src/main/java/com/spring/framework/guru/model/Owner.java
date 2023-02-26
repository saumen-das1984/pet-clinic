package com.spring.framework.guru.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	private Set<Pet> pets = new HashSet<>();
	private String address;
	private String city;
	private String telephone;

}
