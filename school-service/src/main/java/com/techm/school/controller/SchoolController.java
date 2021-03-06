package com.techm.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.school.model.School;
import com.techm.school.repository.SchoolRepository;
import com.techm.school.service.SchoolService;

/**
 * @author achyutananda
 *
 */
@RestController
@RequestMapping("/api")
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	@Autowired
	SchoolRepository schoolRepository;
	
	/**
	 * @author Achyutanada
	 * @return all school data 
	 * @purpose: get all schools list which are available 
	 **/
	@GetMapping("/schools")
    public ResponseEntity<Object> getAllSchools() {
		return new ResponseEntity<Object>(schoolRepository.findAll(), HttpStatus.OK);
    }
	
	/**
	 * @author Achyutanada
	 * @return school data which is created newly
	 * @purpose: create schools data and save it into database 
	 **/
    @PostMapping("/schools")
    public ResponseEntity<Object> createSchool(@Valid @RequestBody School school) {
    	return new ResponseEntity<>(schoolService.saveData(school), HttpStatus.CREATED);
    }
    
    /**
	 * @author Achyutanada
	 * @return school data with respective to school id
	 * @purpose: match and return schools data with respective to school id
	 **/
    @GetMapping(value="/schools/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSchoolById(@PathVariable(value = "id") Long sId) {
    	return new ResponseEntity<>(schoolService.findDataById(sId).toString(), HttpStatus.OK);
    }

}
