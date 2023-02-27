package com.spring.framework.guru.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name="pet_type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
}
