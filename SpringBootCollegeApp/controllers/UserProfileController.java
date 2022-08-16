package com.lecture.SpringBootCollegeApp.controllers;

import com.lecture.SpringBootCollegeApp.model.UserProfile;
import com.lecture.SpringBootCollegeApp.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/displayProfile")
    public ModelAndView displayUserProfile(HttpSession session) {

        UserProfile userProfile = userProfileService.getUserProfile(session);

        ModelAndView modelAndView = new ModelAndView("userProfile.html");
        modelAndView.addObject("userProfile", userProfile);
        return modelAndView;
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile, Errors errors, HttpSession session) {

        if (errors.hasErrors())
            return "userProfile.html";

        userProfileService.updateUserProfile(userProfile, session);

        return "redirect:/displayProfile";
    }
}
