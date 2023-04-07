package com.spring.framework.guru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Builder
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }
	
	@Column(name = "name")
	private String name;
	
	@Override
	public String toString() {
		return name;
	}

}
