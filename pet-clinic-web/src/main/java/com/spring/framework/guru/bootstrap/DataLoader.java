package com.spring.framework.guru.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.model.Pet;
import com.spring.framework.guru.model.PetType;
import com.spring.framework.guru.model.Speciality;
import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.service.OwnerService;
import com.spring.framework.guru.service.PetTypeService;
import com.spring.framework.guru.service.SpecialityService;
import com.spring.framework.guru.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}

	}

	public void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialtyService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialtyService.save(surgery);

		Owner owner1 = new Owner();
		owner1.setFirstName("Owner");
		owner1.setLastName("One");
		owner1.setAddress("Address One Street");
		owner1.setCity("CityOne");
		owner1.setTelephone("11111111");

		Pet pet1 = new Pet();
		pet1.setPetType(savedDogPetType);
		pet1.setOwner(owner1);
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("Pet One");
		owner1.getPets().add(pet1);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Owner");
		owner2.setLastName("Two");
		owner2.setAddress("Address Two Street");
		owner2.setCity("CityTwo");
		owner2.setTelephone("22222222");

		Pet pet2 = new Pet();
		pet2.setPetType(savedCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Pet Two");
		owner2.getPets().add(pet2);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet");
		vet1.setLastName("One");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet");
		vet2.setLastName("Two");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
