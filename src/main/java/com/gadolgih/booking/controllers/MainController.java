package com.gadolgih.booking.controllers;

import com.gadolgih.booking.models.Excursion_list;

import com.gadolgih.booking.repo.Excursion_listRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;
import java.lang.reflect.Array;
import java.util.Iterator;

@Controller

public class MainController {
    @Autowired
    private Excursion_listRepository excursion_listRepository;
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        Iterable<Excursion_list> excursionLists=excursion_listRepository.findAll();
        model.addAttribute("exc", excursionLists);
        return "home";
    }
    @PostMapping("/home")
    public String addExcursion(@RequestParam String name, @RequestParam String description, Model model){

        Excursion_list excursionList=new Excursion_list(name,description);
        excursion_listRepository.save(excursionList);
        Iterable<Excursion_list> excursionLists=excursion_listRepository.findAll();
        model.addAttribute("exc", excursionLists);
        return "home";
    }
}
