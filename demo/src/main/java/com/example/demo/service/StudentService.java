package com.example.demo.service;

import java.util.List;

import com.example.demo.test.Student;

public interface StudentService {
	
	public  Student save(Student student);
	
	public Student getStudent();
	
	public List<Student> getAllDetails();
	
	public Student getAllDetails(Integer id);

	public Student getAllDetails(Integer id, String name);

	public void delete(Integer id);

	public Student udpate(Student student);

	public void updateStatus(Integer id);
}
