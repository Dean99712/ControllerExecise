package com.lecture.SpringBootCollegeApp.service;

import com.lecture.SpringBootCollegeApp.model.Contact;
import com.lecture.SpringBootCollegeApp.model.enums.EInquiryStatus;
import com.lecture.SpringBootCollegeApp.model.enums.EUserRoles;
import com.lecture.SpringBootCollegeApp.repository.ContactRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequestScope
@Getter
@Setter
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private int counter = 0;

    public ContactService() {

        System.out.println("Contact Service bean was initialized!");
    }

    /**
     * @param contact
     * @return
     */

    public boolean saveMessageDetails(Contact contact) {

        contact.setStatus(EInquiryStatus.OPEN.toString());

        Contact queryResults = contactRepository.save(contact);


        return (queryResults != null && queryResults.getInquiryId() > 0);

    }

    public List<Contact> findInquiriesByStatus() {

        List<Contact> inquiriesList = contactRepository.findByStatus(EInquiryStatus.OPEN.toString());

        return  inquiriesList;
    }

    public boolean updateInquiryStatus(int inquiriyId) {

        Optional<Contact> contact = contactRepository.findById(inquiriyId);

        contact.ifPresent(contactObj -> {
            contactObj.setStatus(EInquiryStatus.CLOSE.toString());
        });

        Contact queryResults = contactRepository.save(contact.get());

        return (queryResults != null && queryResults.getUpdatedBy() != null);

    }

}
