package com.springframework.petclinic.controllers;

import com.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets/index.html", "/vets.html"})
    public String getListVet(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
