package com.spring.framework.guru.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {

	private static final long serialVersionUID = 1L;

	@Builder
	public Vet(String firstName, String lastName, Set<Speciality> specialities) {
		super(firstName, lastName);
		this.specialities = specialities;
	}

	@ManyToMany
	@JoinTable(name = "vet_speacialities", joinColumns = @JoinColumn(name="vet_id"),
	inverseJoinColumns = @JoinColumn(name="speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();

}
