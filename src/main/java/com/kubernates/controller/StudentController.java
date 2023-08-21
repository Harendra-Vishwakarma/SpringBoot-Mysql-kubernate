package com.kubernates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubernates.model.Student;
import com.kubernates.repo.StudentRepo;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/save")
	private String saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "data saved";
	}
	@GetMapping("/findAll")
	private List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/find/{id}")
	private Student findById(@PathVariable int id){
		return studentRepo.findById(id).get();
	}

}
