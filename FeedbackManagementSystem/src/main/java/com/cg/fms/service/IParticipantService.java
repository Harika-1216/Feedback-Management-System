package com.cg.fms.service;

import com.cg.fms.entities.Course;
import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Program;
import java.util.*;

public interface IParticipantService {
	
	public Employee enrollParticipant(Employee emp, Program course);
	
	public List<Employee> viewParticipant(Course course);

}
