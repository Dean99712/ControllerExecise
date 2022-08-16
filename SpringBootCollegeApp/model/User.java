package com.lecture.SpringBootCollegeApp.model;

import com.lecture.SpringBootCollegeApp.annotation.FieldsMatch;
import com.lecture.SpringBootCollegeApp.annotation.SecuredPassword;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsMatch.List({

        @FieldsMatch(fieldOne = "pwd", fieldTwo = "confirmPwd", message = "Passwords do not match!"),
        @FieldsMatch(fieldOne = "email", fieldTwo = "confirmEmail", message = "Emails do not match!")
})
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int userId;

    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Mobile number cannot be blank!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Email address is not valid!")
    private String email;

    @NotBlank(message = "Confirm email cannot be blank!")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password field cannot be blank!")
    @SecuredPassword
    private String pwd;

    @NotBlank(message = "Confirm password cannot be blank!")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
    private Roles roles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
    private Address address;

}
