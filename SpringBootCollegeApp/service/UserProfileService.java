package com.lecture.SpringBootCollegeApp.service;

import com.lecture.SpringBootCollegeApp.model.Address;
import com.lecture.SpringBootCollegeApp.model.User;
import com.lecture.SpringBootCollegeApp.model.UserProfile;
import com.lecture.SpringBootCollegeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    public UserProfile getUserProfile(HttpSession session) {

        UserProfile userProfile = new UserProfile();

        User user = (User) session.getAttribute("loggedInUser");

        userProfile.setName(user.getName());
        userProfile.setMobileNumber(user.getMobileNumber());
        userProfile.setEmail(user.getEmail());

        if (user.getAddress() != null && user.getAddress().getAddressId() > 0) {

            userProfile.setAddress1(user.getAddress().getAddress1());
            userProfile.setAddress2(user.getAddress().getAddress2());
            userProfile.setCity(user.getAddress().getCity());
            userProfile.setState(user.getAddress().getState());
            userProfile.setZipCode(user.getAddress().getZipCode());
        }

        return userProfile;

    }

        public void updateUserProfile(UserProfile userProfile, HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        user.setName(userProfile.getName());
        user.setEmail(userProfile.getEmail());
        user.setMobileNumber(userProfile.getMobileNumber());

        if (user.getAddress() == null || !(user.getAddress().getAddressId() > 0))
            user.setAddress(new Address());

        user.getAddress().setAddress1(userProfile.getAddress1());
        user.getAddress().setAddress2(userProfile.getAddress2());
        user.getAddress().setCity(userProfile.getCity());
        user.getAddress().setState(userProfile.getState());
        user.getAddress().setZipCode(userProfile.getZipCode());

        userRepository.save(user);
    }

}
