package com.cg.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Course;
import com.cg.fms.exceptions.CourseNotFoundException;
import com.cg.fms.exceptions.IncorrectNameAndRoleException;
import com.cg.fms.repository.ICourseRepository;

import ch.qos.logback.core.boolex.Matcher;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class ICourseServiceImpl implements ICourseService {
	
	@Autowired
	ICourseRepository addRepo;
	
	@Override
	public Course addCourse(Course course) throws IncorrectNameAndRoleException{
		
		if(validate(course))
		{
			throw new IncorrectNameAndRoleException("Special Characters Not allowed");
		}
		else
		{
			addRepo.save(course);
			return course;

		}
}

	@Override
	public Course updateCourse(Course course) {
		
		addRepo.save(course);
		return course;
	}

	@Override
	public Course removeCourse(Course course) throws CourseNotFoundException{
		
		if(addRepo.findById(course.getCourseId()) != null)
		{
		Optional<Course> cou = addRepo.findById(course.getCourseId());
		addRepo.deleteById(course.getCourseId());
		return cou.get();
		}
		else
		{
			throw new CourseNotFoundException("Course not present in DB");
		}
	}



	@Override
	public List<Course> viewAllCourses() {
		List<Course> lst=addRepo.findAll();
		return lst;
	}

	@Override
	public Course viewCourse(int courseId) throws CourseNotFoundException{
		if(addRepo.existsById(courseId))
		{
		Optional<Course> co = addRepo.findById(courseId);
		return co.get();
		}
		else
		{
			throw new CourseNotFoundException("Course not present in DB");
		}
	
	}
	
	

	public boolean validate(Course course)
	{
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		
		if(course.getCourseId()>0)
		{
			java.util.regex.Matcher hasSpecial = special.matcher(course.getCourseName());
			
			return hasSpecial.find();
		}
		else
		{
			return false;
		}
	}

	
	
}
