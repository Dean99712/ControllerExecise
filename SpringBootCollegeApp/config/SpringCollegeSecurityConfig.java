package com.lecture.SpringBootCollegeApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringCollegeSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/saveMsg","/api/**").and().authorizeRequests()
                .mvcMatchers("/home").authenticated()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/saveMsg").permitAll()
                .mvcMatchers("/courses").permitAll()
                .mvcMatchers("/api/**").authenticated()
                .mvcMatchers("/displayProfile").authenticated()
                .mvcMatchers("/updateProfile").authenticated()
                .mvcMatchers("/holidays/**").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/dash").authenticated()
                .mvcMatchers("/register").permitAll()
                .mvcMatchers("/displayInquiries").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/dash").failureUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll()
                .and().httpBasic();

        return http.build();
    }

}


