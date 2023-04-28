package com.spring.framework.guru.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.service.VetService;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
	
	@Mock
	VetService vetService;
	
	@InjectMocks
	VetController vetController;
	
	MockMvc mockMvc;
	
	Set<Vet> vets;

	@BeforeEach
	void setUp() throws Exception {
		vets = new HashSet<>();
		
		vets.add(Vet.builder()
				.firstName("Vet")
				.lastName("One")
				.specialities(new HashSet<>())
				.build());
		
		vets.add(Vet.builder()
				.firstName("Vet")
				.lastName("Two")
				.specialities(new HashSet<>())
				.build());
		
		mockMvc = MockMvcBuilders.
				standaloneSetup(vetController).
				build();
	}

	@Test
	void testFindAllVets() throws Exception {
		when(vetService.findAll()).thenReturn(vets);

		mockMvc.perform(get("/vets/index"))
				.andExpect(status().isOk())
				.andExpect(view().name("vets/index"));
	}

	@Test
	void testGetVetsJson() throws Exception {
		when(vetService.findAll()).thenReturn(vets);

		mockMvc.perform(get("/api/vets"))
				.andExpect(status().isOk());
	}

}
