package com.techm.student.controller;

import java.util.List;

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

import com.techm.student.model.Student;
import com.techm.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	/**
	 * @author Achyutanada
	 * @return all students data 
	 * @purpose: get all students list which are available 
	 **/
	@GetMapping(value="/students", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.findAllData();
    }
	
	/**
	 * @author Achyutanada
	 * @return students data which is created newly with school name
	 * @purpose: create students data and save it into database 
	 **/
    @PostMapping(value="/students", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<Object>(studentService.saveData(student).toString(), HttpStatus.OK);
    }
    
    /**
	 * @author Achyutanada
	 * @return students data with respective to school id
	 * @purpose: match and return students data with respective to school id
	 **/
    @GetMapping(value="/students/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getStundetById(@PathVariable(value = "id") Long sId) {
    	return new ResponseEntity<>(studentService.findDataById(sId).toString(), HttpStatus.OK);
    }
}
