package com.cg.fms.service;

import com.cg.fms.entities.Course;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface ICourseService {
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public Course removeCourse(Course course);
	
	public Course viewCourse(int courseId);
	
	public List<Course> viewAllCourses();
}
