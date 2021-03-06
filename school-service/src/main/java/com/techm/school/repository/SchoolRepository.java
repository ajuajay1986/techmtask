package com.techm.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.school.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
