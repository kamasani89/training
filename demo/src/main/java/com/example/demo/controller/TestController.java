package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;
import com.example.demo.test.Student;

@RestController // Expose method as end points
@RequestMapping("/student")
public class TestController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<Student> saveDetails(@RequestBody Student student) {
		Student stu = service.save(student);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public ResponseEntity<List<Student>> getDetails() {

		List<Student> stu = service.getAllDetails();

		return new ResponseEntity<List<Student>>(stu, HttpStatus.OK);

	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getDetails(@PathVariable("id") Integer id) {

		Student stu = service.getAllDetails(id);

		return new ResponseEntity<Student>(stu, HttpStatus.OK);

	}
	
	@GetMapping("/get-by-name")
	public ResponseEntity<Student> getDetails(@RequestParam("id") Integer id, @RequestParam("name") String name) {

		Student stu = service.getAllDetails(id,name);

		return new ResponseEntity<Student>(stu, HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {

		service.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> update(@RequestBody Student student) {
		Student stu = service.udpate(student);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);

	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Void> updateStatus(@PathVariable("id") Integer id) {

		service.updateStatus(id);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@GetMapping
	private ResponseEntity<Student> getStudent() {

		Student sudent = service.getStudent();

		return new ResponseEntity<Student>(sudent, HttpStatus.OK);
	}

}
