package com.lecture.SpringBootCollegeApp.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Registration {


    @NotBlank(message = "Name must not be blank!")
    private String name;

    @Email(message = "Please enter valid email address!")
    private String email;

    @Pattern(regexp = "[0-9]{10}", message = "Please enter 10 digits!")
    private String phone;

    @NotBlank(message = "Password field is mandatory!")
    private String password;
}

