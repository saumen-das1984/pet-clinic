package com.spring.framework.guru.service.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.repository.OwnerRepository;
import com.spring.framework.guru.repository.PetRepository;
import com.spring.framework.guru.repository.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	private static final Long OWNER_ID = 1L;
	private static final String LAST_NAME ="Smith";
	
	Owner returnedOwner;
	
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService ownerSDJpaService;

	@BeforeEach
	void setUp() {
		returnedOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
	}

	@Test
	void testFindAll() {
		Set<Owner> returnedOwnerSet = new HashSet<>();
		returnedOwnerSet.add(Owner.builder().id(1l).build());
		returnedOwnerSet.add(Owner.builder().id(2l).build());
		when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);
		
		Set<Owner> ownersSet = ownerSDJpaService.findAll();
		assertNotNull(ownersSet);
		assertEquals(2, ownersSet.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));
		Owner owner = ownerSDJpaService.findById(OWNER_ID);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(any())).thenReturn(Optional.empty());
		Owner owner = ownerSDJpaService.findById(3L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnedOwner);
		Owner ownerToSave = Owner.builder().id(1l).build();
		Owner savedOwner = ownerSDJpaService.save(ownerToSave);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		ownerSDJpaService.delete(returnedOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerSDJpaService.deleteById(OWNER_ID);
		verify(ownerRepository).deleteById(any());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
		Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME, smith.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

}
