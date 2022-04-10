package com.springboot.demo.service;

import java.util.Set;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;

public interface CourseService {
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public Set<Course> getCourses();
	
	public Course getCourse(Long courseId);
	
	public void deleteCourse(Long courseId);

	public Set<Course> getCoursesOfInstitute(Institute institute);

	public Set<Course> getByKeyword(String keyword);
}