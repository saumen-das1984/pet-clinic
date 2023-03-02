package com.spring.framework.guru.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.model.Pet;
import com.spring.framework.guru.model.PetType;
import com.spring.framework.guru.model.Speciality;
import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.model.Visit;
import com.spring.framework.guru.service.OwnerService;
import com.spring.framework.guru.service.PetTypeService;
import com.spring.framework.guru.service.SpecialityService;
import com.spring.framework.guru.service.VetService;
import com.spring.framework.guru.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
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

//		Owner owner1 = new Owner();
//		owner1.setFirstName("Owner");
//		owner1.setLastName("One");
//		owner1.setAddress("Address One Street");
//		owner1.setCity("CityOne");
//		owner1.setTelephone("11111111");
		
		Owner owner1 = Owner.builder()
				.firstName("Owner")
				.lastName("One")
				.address("Address One Street")
				.city("CityOne")
				.telephone("11111111")
				.pets(new HashSet<>())
				.build();

//		Pet pet1 = new Pet();
//		pet1.setPetType(savedDogPetType);
//		pet1.setOwner(owner1);
//		pet1.setBirthDate(LocalDate.now());
//		pet1.setName("Pet One");
		
		Pet pet1 = Pet.builder()
				.petType(savedDogPetType)
				.owner(owner1)
				.birthDate(LocalDate.now())
				.name("Pet One")
				.build();
		
		owner1.getPets().add(pet1);

		ownerService.save(owner1);

//		Owner owner2 = new Owner();
//		owner2.setFirstName("Owner");
//		owner2.setLastName("Two");
//		owner2.setAddress("Address Two Street");
//		owner2.setCity("CityTwo");
//		owner2.setTelephone("22222222");
		
		Owner owner2 = Owner.builder()
				.firstName("Owner")
				.lastName("Two")
				.address("Address Two Street")
				.city("CityTwo")
				.telephone("22222222")
				.pets(new HashSet<>())
				.build();

//		Pet pet2 = new Pet();
//		pet2.setPetType(savedCatPetType);
//		pet2.setOwner(owner2);
//		pet2.setBirthDate(LocalDate.now());
//		pet2.setName("Pet Two");
		
		Pet pet2 = Pet.builder()
				.petType(savedCatPetType)
				.owner(owner2)
				.birthDate(LocalDate.now())
				.name("Pet Two")
				.build();
		
		owner2.getPets().add(pet2);

		ownerService.save(owner2);
		
//		Visit petVisit = new Visit();
//		petVisit.setPet(pet2);
//		petVisit.setDate(LocalDate.now());
//		petVisit.setDescription("Pet2 Visit");
		
		Visit petVisit = Visit.builder()
				.pet(pet2)
				.date(LocalDate.now())
				.description("Pet2 Visit")
				.build();
				
		visitService.save(petVisit);

		System.out.println("Loaded Owners....");

//		Vet vet1 = new Vet();
//		vet1.setFirstName("Vet");
//		vet1.setLastName("One");
		
		Vet vet1 = Vet.builder()
				.firstName("Vet")
				.lastName("One")
				.specialities(new HashSet<>())
				.build();
		
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

//		Vet vet2 = new Vet();
//		vet2.setFirstName("Vet");
//		vet2.setLastName("Two");
		
		Vet vet2 = Vet.builder()
				.firstName("Vet")
				.lastName("Two")
				.specialities(new HashSet<>())
				.build();
		
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
