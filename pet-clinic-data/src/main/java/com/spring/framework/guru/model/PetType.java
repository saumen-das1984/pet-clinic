package com.spring.framework.guru.model;

import lombok.Data;

@Data
public class PetType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;

}
