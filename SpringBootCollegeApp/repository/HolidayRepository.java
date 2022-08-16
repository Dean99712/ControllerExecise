package com.lecture.SpringBootCollegeApp.repository;

import com.lecture.SpringBootCollegeApp.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends CrudRepository<Holiday,String> {

}
