package com.spring.framework.guru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.framework.guru.service.VetService;

@Controller
public class VetController {
	
	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html" })
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
