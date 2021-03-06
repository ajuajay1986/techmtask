package com.techm.school.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.school.exception.ResourceNotFoundException;
import com.techm.school.model.School;
import com.techm.school.repository.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	SchoolRepository schoolRepository;
	

	public List<School> findAllData() {
		return schoolRepository.findAll();
	}
	
	public School saveData(School school) {
		return schoolRepository.save(school);
	}

	public JSONObject findDataById(Long schoolId) {
		JSONObject resp = new JSONObject();
		Optional<School> school = schoolRepository.findById(schoolId);
		if(school.isPresent()) {
			resp.put("status", 200);
			resp.put("message", "Success");
			resp.put("data", new JSONObject(school.get()));
		}else {
			throw new ResourceNotFoundException(schoolId.toString());
		}
		return resp;
	}

}
