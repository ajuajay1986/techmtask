package com.techm.student.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techm.student.exception.SchoolNotFoundException;
import com.techm.student.exception.StudentNotFoundException;
import com.techm.student.model.Student;
import com.techm.student.repository.StudentRepository;

@Service
public class StudentService {
	JSONObject rr = new JSONObject();
	
	@Autowired
	StudentRepository studentRepository;
	
	final String uri = "http://localhost:8181/api/schools";

	public List<Student> findAllData() {
		return studentRepository.findAll();
	}

	public JSONObject saveData(@Valid Student student) {
		/*start calling school service to get school data with respective to id*/
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri+"/"+student.getSchoolId(), String.class);
		JSONObject response = new JSONObject(result); 
		JSONObject res = new JSONObject(); 
		if(response.has("status") && response.getInt("status")==200) {
			res.put("status", 200);
			res.put("message", "success");
			res.put("data", new JSONObject(studentRepository.save(student)).
					put("schoolName", response.getJSONObject("data").getString("name")));
		}else {
			throw new SchoolNotFoundException(student.getSchoolId().toString());
		}
		
		return res;
	}

	public JSONObject findDataById(Long sId) {
		JSONObject resp = new JSONObject();
		Optional<Student> student = studentRepository.findById(sId);
		if(student.isPresent()) {
			/*start calling school service to get school data with respective to id*/
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri+"/"+student.get().getSchoolId(), String.class);
			JSONObject response = new JSONObject(result); 
			resp.put("status", 200);
			resp.put("message", "Success");
			resp.put("data", new JSONObject(student.get())
					.put("schoolName", response.getJSONObject("data").getString("name")));
		}else {
			throw new StudentNotFoundException(sId.toString());
		}
		return resp;
	}
	
	

}
