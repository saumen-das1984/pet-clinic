package com.spring.framework.guru.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	private Set<Pet> pets;
	private String address;
	private String city;
	private String telephone;

}
