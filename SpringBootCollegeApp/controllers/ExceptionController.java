package com.lecture.SpringBootCollegeApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(annotations = Controller.class)
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e) {

        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("exception");
        errorPage.addObject("errorMsg", e.getMessage());

        return errorPage;
    }
}
