package com.lecture.SpringBootCollegeApp.security;

import com.lecture.SpringBootCollegeApp.model.Roles;
import com.lecture.SpringBootCollegeApp.model.User;
import com.lecture.SpringBootCollegeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringCollegeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        User user = userRepository.readByEmail(email);

        if (user != null && user.getUserId() > 0 && passwordEncoder.matches(pwd,user.getPwd()))
            return new UsernamePasswordAuthenticationToken(user.getName(),pwd,getGrantedAuth(user.getRoles()));

        return null;
    }

    private List<GrantedAuthority> getGrantedAuth(Roles roles) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
