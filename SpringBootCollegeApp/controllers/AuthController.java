package com.lecture.SpringBootCollegeApp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class AuthController {

    private String message;


    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLoginPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String logout,
            @RequestParam(required = false) String register,
            Model model)
    {

        if (error != null)
            message = "Username or Password is incorrect!";

        else if (logout != null)
            message = "You have been successfully logged out!";

        else if (register != null)
            message = "Registration process was done successfully!";

        model.addAttribute("message", message);

        return "login.html";
    }


    @GetMapping("/logout")
    public String displayLogoutPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null)
            new SecurityContextLogoutHandler().logout(request,response,auth);

        return "redirect:/login?logout=true";
    }

}
