package com.spring.framework.guru.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	private static final String EMPTY_STRING = "";
	private static final String PERCENTAGE_SIGN = "%";
	private static final String LAST_NAME = "lastName";
	private static final String NOT_FOUND = "not found";
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@GetMapping({"/index", "/index.html" })
	public String index(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
	
	@GetMapping({"/oups"})
	public String findOwners() {
		return "notimplemented";
	}
	
	@GetMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }
	
	@GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
		if(null == owner.getLastName()) {
			owner.setLastName(EMPTY_STRING);
		}
		
		List<Owner> owners = ownerService.findAllByLastNameLike(PERCENTAGE_SIGN + owner.getLastName() + PERCENTAGE_SIGN);
		if(owners.isEmpty()) {
			result.rejectValue(LAST_NAME, NOT_FOUND, NOT_FOUND);
			return "owners/findOwners";
		} else if (owners.size() == 1) {
			owner = owners.get(0);
			return "redirect:/owners/" + owner.getId();
		}  else {
			model.addAttribute("selections", owners);
            return "owners/ownersList";
		}
	}
	
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

}
