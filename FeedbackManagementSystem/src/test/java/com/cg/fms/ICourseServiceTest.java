package com.cg.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.entities.Course;
import com.cg.fms.repository.ICourseRepository;
import com.cg.fms.service.ICourseService;

@SpringBootTest
public class ICourseServiceTest {
	@Autowired
	ICourseService courseService;
	@MockBean
	ICourseRepository courseRepo;
	
	@Test
	public void testAddCourse()
	{
	Course cou = new Course();	
	cou.setCourseId(123);
	cou.setCourseName("Sprint");
	cou.setCourseDescription("Java Program");
	cou.setNoOfDays(12);
	Mockito.when(courseRepo.save(cou)).thenReturn(cou);
	assertThat(courseService.addCourse(cou)).isEqualTo(cou);
	}
	
	@Test
	public void testUpdateCourse()
	{
		Course cou = new Course();	
		cou.setCourseId(123);
		cou.setCourseName("Sprint");
		cou.setCourseDescription("Java Program");
		cou.setNoOfDays(12);
		Mockito.when(courseRepo.findById(cou.getCourseId())).thenReturn(Optional.of(cou));
		cou.setCourseName("Angular");
		Mockito.when(courseRepo.save(cou)).thenReturn(cou);
		
		assertThat(courseService.updateCourse(cou)).isEqualTo(cou);
	}
	@Test
	public void testRemoveCourse()
	{
		Course cou = new Course();	
		cou.setCourseId(123);
		cou.setCourseName("Sprint");
		cou.setCourseDescription("Java Program");
		cou.setNoOfDays(12);
		Mockito.when(courseRepo.findById(cou.getCourseId())).thenReturn(Optional.of(cou));
	    Mockito.when(courseRepo.existsById(cou.getCourseId())).thenReturn(false);
	   assertFalse(courseRepo.existsById(cou.getCourseId()));
	}
	@Test
	public void viewCourseByCourseId()
	{
		Course cou = new Course();	
		cou.setCourseId(123);
		cou.setCourseName("Sprint");
		cou.setCourseDescription("Java Program");
		cou.setNoOfDays(12);
		Mockito.when(courseRepo.findById(cou.getCourseId())).thenReturn(Optional.of(cou));
		assertThat(courseService.viewCourse(cou.getCourseId())).isEqualTo(cou);
	}
	
	@Test
	public void viewAllCourses()
	{
		Course cou1 = new Course();	
		cou1.setCourseId(123);
		cou1.setCourseName("Sprint");
		cou1.setCourseDescription("Java Program");
		cou1.setNoOfDays(12);
		Course cou2 = new Course();	
		cou2.setCourseId(345);
		cou2.setCourseName("Sprint2");
		cou2.setCourseDescription("Java");
		cou2.setNoOfDays(15);
		
		List<Course> addList = new ArrayList<>();
		addList.add(cou1); addList.add(cou2);
		
		Mockito.when(courseRepo.findAll()).thenReturn(addList);
		
		assertThat(courseService.viewAllCourses()).isEqualTo(addList);
	}
	

}