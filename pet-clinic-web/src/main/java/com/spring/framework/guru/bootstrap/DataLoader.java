package com.spring.framework.guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.service.OwnerService;
import com.spring.framework.guru.service.VetService;
import com.spring.framework.guru.service.map.OwnerServiceMap;
import com.spring.framework.guru.service.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}


	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
        owner1.setFirstName("Owner");
        owner1.setLastName("One");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
		owner2.setId(2L);
        owner2.setFirstName("Owner");
        owner2.setLastName("Two");
        ownerService.save(owner2);
        
        System.out.println("Loaded Owners....");
        
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet");
        vet1.setLastName("One");
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet");
        vet2.setLastName("Two");
        vetService.save(vet2);
        
        System.out.println("Loaded Vets....");
	}

}
