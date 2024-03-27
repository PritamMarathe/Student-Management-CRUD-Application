package com.StudManagementSystem.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudManagementSystem.Repo.StudRepo;
import com.StudManagementSystem.model.Student;


@Service
public class StudService {

	@Autowired
	StudRepo repo;
	
//	Get All Students
	public List<Student> listAll() {
		return repo.findAll();
	}
	
//	Add Student
	public void save(Student student) {
		repo.save(student);
	}

//	Get Student By Id
	public Student get(Integer id) {
		return repo.findById(id).get();
	}
	
//	Update/Edit Student by Id
	public Student updateStudent(Student stud, int id) {
		Student std=repo.findById(id).get();
		
		if(Objects.nonNull(stud.getFirstname())
				&& !"".equalsIgnoreCase(stud.getFirstname())) {
			std.setFirstname(stud.getFirstname());
			std.setLastname(stud.getLastname());
			std.setPercentage(stud.getPercentage());
			std.setStandard(stud.getStandard());
			std.setGender(stud.getGender());
			std.setEmail(stud.getEmail());
			std.setPhoneNo(stud.getPhoneNo());
		}
		
		return repo.save(std);
	}

//	Delete Student
	public void delete(Student student) {
		this.repo.delete(student);
	}

	

	

}
