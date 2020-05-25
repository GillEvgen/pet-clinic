package com.springframework.petclinic.controllers;

import com.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("/index")
    public String getListOwners(Model model) {
        model.addAttribute("owner", ownerService.findAll());
        return "owner/index";
    }
}
