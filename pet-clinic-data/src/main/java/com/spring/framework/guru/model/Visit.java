package com.spring.framework.guru.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private String description;
	private Pet pet;

}
