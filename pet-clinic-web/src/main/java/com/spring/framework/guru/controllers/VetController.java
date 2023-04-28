package com.spring.framework.guru.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.framework.guru.model.Vet;
import com.spring.framework.guru.service.VetService;

@Controller
public class VetController {
	
	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({ "/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html" })
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){
        return vetService.findAll();
    }
}
