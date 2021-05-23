package com.cg.fms.service;

import com.cg.fms.entities.Employee;
import java.util.*;

public interface ITrainerManagementService {
	
	public Employee addTrainer(Employee emp);
	
	public Employee updateTrainer(Employee emp);
	
	public Employee removeTrainer(Employee emp);
	
	public Employee viewTrainer(int emp);
	
	public List<Employee> viewAllTrainers();
	
}
