package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.service.StudentService;
import com.example.demo.test.Address;
import com.example.demo.test.Student;

@Component("student")
public class StudentServiceImpl2 implements StudentService {

	Map<Integer, Student> studentList = new HashMap<>();

	@Override
	public Student getStudent() {
		Student s = new Student();
		s.setId(1);
		s.setName("narasiha");
		Address address = new Address();
		address.setAddressLine1("Tpt");
		address.setAddressLine1("MR Palli");
		s.setAddress(address);
		return s;
	}

	@Override
	public Student save(Student student) {

		Random r = new Random();
		int id = r.nextInt();
		student.setId(id);
		studentList.put(id, student);
		return student;
	}

	@Override
	public List<Student> getAllDetails() {
		List<Student> student = new ArrayList<>();
		
		Set<Map.Entry<Integer,Student>>  entrySet = studentList.entrySet();
		for (Entry<Integer, Student> entry : entrySet) {
			student.add(entry.getValue());
		}
		
		return student;
	}

	@Override
	public Student getAllDetails(Integer id) {
		
		return studentList.get(id);
		
	}

	@Override
	public Student getAllDetails(Integer id, String name) {
		
		Student s = studentList.get(id);
		if(s.getName().equals(name)) {
			return s;
		}else {
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		studentList.remove(id);		
	}

	@Override
	public Student udpate(Student student) {
		Student s  = studentList.get(student.getId());
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		studentList.put(student.getId(), s);
		return s;
	}

	@Override
	public void updateStatus(Integer id) {
		Student s  = studentList.get(id);
		s.setActive(false);
		studentList.put(id, s);
	}

}
