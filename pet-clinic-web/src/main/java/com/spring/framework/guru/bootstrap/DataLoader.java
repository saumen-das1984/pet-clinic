package com.spring.framework.guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.model.PetType;
import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.service.OwnerService;
import com.spring.framework.guru.service.PetTypeService;
import com.spring.framework.guru.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
        owner1.setFirstName("Owner");
        owner1.setLastName("One");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Owner");
        owner2.setLastName("Two");
        ownerService.save(owner2);
        
        System.out.println("Loaded Owners....");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("One");
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Two");
        vetService.save(vet2);
        
        System.out.println("Loaded Vets....");
	}

}
