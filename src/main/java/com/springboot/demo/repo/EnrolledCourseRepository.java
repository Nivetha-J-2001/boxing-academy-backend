package com.springboot.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.AppliedCourse;
import com.springboot.demo.model.Course;
import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.model.Institute;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse,Long> {

	public void save(AppliedCourse appliedCourse);
	
	public Set<EnrolledCourse> findByStudent(Student student);
	
	public Set<EnrolledCourse> findByUser(User user);

	public Object findByCourse(Course course);
	
	@Query(value = "select * from enrolledcourse s where s.user_id like :userId and s.course_id like :courseId", nativeQuery = true)
	public Object findByenrolledcourse(@Param("userId") long userId, @Param("courseId") long courseId);
	

}
