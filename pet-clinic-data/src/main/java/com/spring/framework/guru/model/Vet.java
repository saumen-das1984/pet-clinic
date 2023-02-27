package com.spring.framework.guru.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vets")
public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(name = "vet_speacialities", joinColumns = @JoinColumn(name="vet_id"),
	inverseJoinColumns = @JoinColumn(name="speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();

}
