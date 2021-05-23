package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Employee;
import com.cg.fms.service.ITrainerManagementService;

import java.util.*;

@RestController
@RequestMapping("Fms/api")
public class EmployeeController {
	
	@Autowired
	ITrainerManagementService itm;
	
	@PostMapping("/Trainer")
	public Employee addTrainer(Employee emp)
	{
		return itm.addTrainer(emp);
	}
	
	@GetMapping("/EmployeeViewA")
	public List<Employee> viewAllEmployees()
	{
		return itm.viewAllTrainers();
	}
	
	@GetMapping("/EmployeeView")
	public Employee viewEmployee(int emp)
	{
		return itm.viewTrainer(emp);
	}
	
	@PutMapping("EmployeeUp")
	public Employee updateEmployee(Employee emp)
	{
	   return itm.updateTrainer(emp);
	}
	
	@DeleteMapping("EmployeeRem")
	public Employee removeEmployee(Employee emp)
	{
		return itm.removeTrainer(emp);
	}

}
