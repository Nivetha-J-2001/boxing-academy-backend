package com.springboot.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceFoundException;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.EnrolledCourse;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;
import com.springboot.demo.repo.EnrolledCourseRepository;
import com.springboot.demo.service.EnrolledCourseService;

@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService {
	
	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;
	@Override
	public EnrolledCourse addEnrolledCourse(EnrolledCourse enrolledCourse) {
		// TODO Auto-generated method stub
		if(this.enrolledCourseRepository.findByenrolledcourse(enrolledCourse.getStudent().getStudentId(),enrolledCourse.getCourse().getCourseId())!=null) 
			throw new ResourceFoundException("Course Already enrolled !!"); 
		return this.enrolledCourseRepository.save(enrolledCourse);
	}

	@Override
	public EnrolledCourse updateEnrolledCourse(EnrolledCourse enrolledCourse) {
		// TODO Auto-generated method stub
		this.enrolledCourseRepository.findById(enrolledCourse.getEnrolledId())
		.orElseThrow(()->new ResourceNotFoundException("applied course not found to update in this id : "+enrolledCourse.getEnrolledId()));
		EnrolledCourse c1=enrolledCourseRepository.findById(enrolledCourse.getEnrolledId()).get();
		enrolledCourse.setCreatedAt(c1.getCreatedAt());
		enrolledCourse.setJoinedDate(c1.getJoinedDate());
		return this.enrolledCourseRepository.save(enrolledCourse);
	}

	@Override
	public Set<EnrolledCourse> getEnrolledCourses() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.enrolledCourseRepository.findAll());
	}

	@Override
	public EnrolledCourse getEnrolledCourse(Long enrolledId) {
		// TODO Auto-generated method stub
		this.enrolledCourseRepository.findById(enrolledId)
		.orElseThrow(()->new ResourceNotFoundException("applied course not found to update in this id : "+enrolledId));
		return this.enrolledCourseRepository.findById(enrolledId).get();
	}

	@Override
	public void deleteEnrolledCourse(Long enrolledId) {
		// TODO Auto-generated method stub
		this.enrolledCourseRepository.findById(enrolledId)
		.orElseThrow(()->new ResourceNotFoundException("applied course not found to update in this id : "+enrolledId));
		
		EnrolledCourse enrolledCourse=new EnrolledCourse();
		enrolledCourse.setEnrolledId(enrolledId);
		this.enrolledCourseRepository.delete(enrolledCourse);
	}
	
	@Override
	public Set<EnrolledCourse> getCourseofStudent(Student student) {
		// TODO Auto-generated method stub
		return this.enrolledCourseRepository.findByStudent(student);
	}
	@Override
	public Set<EnrolledCourse> getEnrolledCourseByUserId(User user){
		return this.enrolledCourseRepository.findByUser(user);
	}

	@Override
	public Boolean checkStatus(long courseId, long studentId) {
		// TODO Auto-generated method stub
		Object local=this.enrolledCourseRepository.findByenrolledcourse(studentId,courseId);
		if(local!=null) return true;
		return false;
	}

}
