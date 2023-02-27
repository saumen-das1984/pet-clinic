package com.spring.framework.guru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;

}
