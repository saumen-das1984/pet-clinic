package com.spring.framework.guru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "description")
	private String description;

}
