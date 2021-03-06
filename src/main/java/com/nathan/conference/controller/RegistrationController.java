package com.nathan.conference.controller;

import com.nathan.conference.model.Registration;
import com.nathan.conference.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    @Qualifier("jdbcBookRepository")
    private RegistrationRepo registrationRepo;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration){
        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute("registration") Registration registration,
                                  BindingResult result){
        if(result.hasErrors()){
            System.out.println("there were errors");
            return "registration";
        }
        System.out.println("Registration: " + registration.getName());
        registrationRepo.save(registration);
        return "redirect:registration";
    }
}
