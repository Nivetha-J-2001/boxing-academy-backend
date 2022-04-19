package com.springboot.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceFoundException;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Course;
import com.springboot.demo.model.Institute;
import com.springboot.demo.repo.CourseRepository;
import com.springboot.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		Course local = this.courseRepository.findByCourseName(course.getCourseName());
		if (local != null)
			throw new ResourceFoundException("Course Already Present !!");
		return this.courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		this.courseRepository.findById(course.getCourseId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"course not found to update in this name : " + course.getCourseName()));
		Course c1 = courseRepository.findById(course.getCourseId()).get();
		course.setCreatedAt(c1.getCreatedAt());
		return this.courseRepository.save(course);
	}

	@Override
	public Set<Course> getCourses() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.courseRepository.findAll());
	}

	@Override
	public Course getCourse(Long courseId) {
		// TODO Auto-generated method stub
		this.courseRepository.findById(courseId)
				.orElseThrow(
						() -> new ResourceNotFoundException("course not found to update in this for id : " + courseId));
		return this.courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourse(Long courseId) {
		Course course = this.courseRepository.findById(courseId)
				.orElseThrow(
						() -> new ResourceNotFoundException("course not found to update in this for id : " + courseId));
		this.courseRepository.delete(course);
	}

	@Override
	public Set<Course> getCoursesOfInstitute(Institute institute) {
		return this.courseRepository.findByInstitute(institute);
	}

	@Override
	public Set<Course> getByKeyword(String keyword) {
		return this.courseRepository.findByKeyword(keyword);
	}

	@Override
	public Set<Course> searchAcademyCourseByKeyword(int insId, String keyword) {
		return this.courseRepository.findByKeywordAcademyCourse(insId, keyword);
	}

	@Override
	public Set<Course> searchUserEnrolledCourseByKeyword(long userId, String keyword) {

		return this.courseRepository.findByKeywordUserEnrolledCourse(userId, keyword);
	}

}