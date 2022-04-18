package com.springboot.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;

public interface CourseRepository extends JpaRepository<Course,Long> {

	Set<Course> findByInstitute(Institute institute);

	public Course findByCourseName(String courseName);
	
	@Query(value = "select * from course s where s.course_name like %:keyword% or s.course_duration like %:keyword%"
			+ " or s.course_cost like %:keyword% or s.course_desc like %:keyword% " , nativeQuery = true)
	 public Set<Course> findByKeyword(@Param("keyword") String keyword);
	
}