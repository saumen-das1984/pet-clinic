package com.spring.framework.guru.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.spring.framework.guru.model.Owner;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	
	private Long id = 1L;
	private String lastName = "Smith";

	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(id);
		assertEquals(1, owner.getId());
	}

	@Test
	void testSaveOwnerWithId() {
		Long ownerId = 2L;
		Owner owner2 = Owner.builder().id(ownerId).build();
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertEquals(ownerId, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerWithOutId() {
		Owner owner2 = Owner.builder().build();
		Owner savedOwner = ownerMapService.save(owner2);
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(id));
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(id);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerMapService.findByLastName(lastName);
		assertNotNull(smith);
		assertNotNull(smith.getId());
	}

}
