package com.StudManagementSystem.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudManagementSystem.Repo.StudRepo;
import com.StudManagementSystem.model.Student;
import com.StudManagementSystem.service.StudService;

@RestController
public class StudController {
	
	@Autowired
	StudService service;
	
	@Autowired
	StudRepo repo;
	
//	Post Student
	@PostMapping("/addstud")
	public void saveStudents(@RequestBody Student student) {
		service.save(student);
	}
	
//	Get All Sttudents
	@GetMapping("/getstud")
	public List<Student> getStudents() {
		return service.listAll();
	}
	
//	Get Student By Id
	@GetMapping("/getstud/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
		try {
			Student student = service.get(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
//	Update/Edit the Student by Id
	@PutMapping("/editstud/{id}")
	public Student updateStudent(@RequestBody Student stud, @PathVariable("id") int id) {
		return service.updateStudent(stud, id);
	}
	

//	Delete Student By Id
	@DeleteMapping("/deletestud/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		Optional<Student> sd=this.repo.findById(id);
		if(sd.isPresent()) {
			this.service.delete(sd.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
