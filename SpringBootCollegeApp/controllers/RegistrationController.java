package com.lecture.SpringBootCollegeApp.controllers;

import com.lecture.SpringBootCollegeApp.model.Registration;
import com.lecture.SpringBootCollegeApp.model.User;
import com.lecture.SpringBootCollegeApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String displayRegistrationPage(Model model) {

        model.addAttribute("user", new User());
        return "registration.html";
    }


    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("user") User user, Errors errors) {

        if (errors.hasErrors())
            return "registration.html";

        return userService.createNewUser(user) ? "redirect:/login?register=true" : "registration.html";
    }

}

