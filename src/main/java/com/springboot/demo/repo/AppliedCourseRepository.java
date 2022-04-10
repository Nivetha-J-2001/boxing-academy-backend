package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.AppliedCourse;
import com.springboot.demo.model.Course;
import com.springboot.demo.model.Student;

public interface AppliedCourseRepository extends JpaRepository<AppliedCourse,Long> {

	public AppliedCourse findByCourse(Course course);

	public Object findByStudent(Student student);
	
	@Query(value = "select * from appliedcourse s where s.student_id like %:studentId% and s.course_id like %:courseId%", nativeQuery = true)
	public Object findByappliedcourse(@Param("studentId") long studentId, @Param("courseId") long courseId);
}
