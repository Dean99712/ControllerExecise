package com.lecture.SpringBootCollegeApp.service;

import com.lecture.SpringBootCollegeApp.model.User;
import com.lecture.SpringBootCollegeApp.model.enums.EUserRoles;
import com.lecture.SpringBootCollegeApp.repository.RolesRepository;
import com.lecture.SpringBootCollegeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewUser(User user) {

        user.setRoles(
                rolesRepository.getByRoleName(EUserRoles.USER.toString())
        );

        user.setPwd(
                passwordEncoder.encode(user.getConfirmPwd())
        );

        user = userRepository.save(user);

        return (user != null && user.getUserId() > 0);
    }
}
