package com.springboot.demo.service;

import java.util.Set;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;

public interface EnrolledCourseService {

	public EnrolledCourse addEnrolledCourse(EnrolledCourse enrolledCourse);

	public EnrolledCourse updateEnrolledCourse(EnrolledCourse enrolledCourse);

	public Set<EnrolledCourse> getEnrolledCourses();

	public EnrolledCourse getEnrolledCourse(Long enrolledId);

	public void deleteEnrolledCourse(Long enrolledId);

	public Set<EnrolledCourse> getCourseofStudent(Student student);

	public Set<EnrolledCourse> getEnrolledCourseByUserId(User user);

	public Boolean checkStatus(long courseId, long studentId);
	
}
