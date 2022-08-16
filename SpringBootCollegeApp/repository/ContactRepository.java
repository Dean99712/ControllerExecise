package com.lecture.SpringBootCollegeApp.repository;

import com.lecture.SpringBootCollegeApp.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);
    List<Contact> findBySubjectContaining(String subject);


}
