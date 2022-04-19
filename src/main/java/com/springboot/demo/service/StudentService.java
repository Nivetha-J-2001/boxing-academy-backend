package com.springboot.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;

public interface StudentService {

	public Student addStudent(Student student);

	public Student updateStudent(Student student);
	
	public Set<Student> getStudents();
	
	public Student getStudent(long studentId);

    public void deleteStudent(Long studentId);

	public List<Object> getByKeyword(String keyword);

	public Set<Student> getStudentsofUser(User user);

}
