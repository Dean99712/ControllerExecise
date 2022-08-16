package com.lecture.SpringBootCollegeApp.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserProfile {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number cannot be blank!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Email address is not valid!")
    private String email;

    @NotBlank( message = "Address1 must not be blank!")
    @Size(min = 4, message = "Address1 must be at least 4 characters long!")
    private String address1;

    private String address2;

    @NotBlank( message = "City must not be blank!")
    @Size(min = 3, message = "City must be at least 3 characters long!")
    private String city;

    private String state;

    @NotBlank( message = "Zip Code must not be blank!")
    @Pattern(regexp = "[0-9]", message = "Zip code must contain digits only!")
    private String zipCode;
}
