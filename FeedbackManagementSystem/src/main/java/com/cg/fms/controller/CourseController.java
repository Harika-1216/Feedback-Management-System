package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.fms.entities.Course;
import com.cg.fms.service.ICourseService;
import com.cg.fms.service.ICourseServiceImpl;

import java.util.*;

@RestController
@RequestMapping("/Fms/api")
public class CourseController {

	@Autowired
	ICourseService courseService;
	
	@PostMapping("/Course")
	public Course addCourse(Course cou)
	{
		return courseService.addCourse(cou);
	}
	
	@PutMapping("/CourseUp")
	public Course updateCourse(Course cou)
	{
		return courseService.updateCourse(cou);
	}
	
	@DeleteMapping("/CourseRem")
	public Course removeCourse(Course cou)
	{
		return courseService.removeCourse(cou);
	}
	
	@GetMapping("/CourseViewA")
	public List<Course> viewAllCourses()
    {
		return courseService.viewAllCourses();
	}
	
	@GetMapping("/CourseView")
	public Course viewCourse(int courseId)
    {
		return courseService.viewCourse(courseId);
	}
	

	
}
