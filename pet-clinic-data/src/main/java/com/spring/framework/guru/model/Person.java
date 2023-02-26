package com.spring.framework.guru.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;

}
