package com.lecture.SpringBootCollegeApp.repository;

import com.lecture.SpringBootCollegeApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User readByEmail(String email);
}
