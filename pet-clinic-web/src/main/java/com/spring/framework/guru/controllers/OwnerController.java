package com.spring.framework.guru.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.framework.guru.model.Owner;
import com.spring.framework.guru.service.OwnerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
	private static final String OWNER_INDEX = "owners/index";
	private static final String FIND_OWNERS = "owners/findOwners";
	private static final String REDIRECT_OWNERS = "redirect:/owners/";
	private static final String LIST_OF_OWNERS = "owners/ownersList";
	
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
		return OWNER_INDEX;
	}
	
	@GetMapping({"/oups"})
	public String findOwners() {
		return "notimplemented";
	}
	
	@GetMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return FIND_OWNERS;
    }
	
	@GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
		if(null == owner.getLastName()) {
			owner.setLastName(EMPTY_STRING);
		}
		
		List<Owner> owners = ownerService.findAllByLastNameLike(PERCENTAGE_SIGN + owner.getLastName() + PERCENTAGE_SIGN);
		if(owners.isEmpty()) {
			result.rejectValue(LAST_NAME, NOT_FOUND, NOT_FOUND);
			return FIND_OWNERS;
		} else if (owners.size() == 1) {
			owner = owners.get(0);
			return REDIRECT_OWNERS + owner.getId();
		}  else {
			model.addAttribute("selections", owners);
            return LIST_OF_OWNERS;
		}
	}
	
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
    
    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner =  ownerService.save(owner);
            return REDIRECT_OWNERS + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return REDIRECT_OWNERS + savedOwner.getId();
        }
    }

}
