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
import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Role;
import com.cg.fms.repository.ITrainerManagementRepository;
import com.cg.fms.service.ITrainerManagementService;

@SpringBootTest
public class ITrainerManagementServiceTest {
	@Autowired
	ITrainerManagementService trainerService;
	@MockBean
	ITrainerManagementRepository trainerRepo;
	
	@Test
	public void testAddTrainer()
	{
	Employee emp = new Employee();	
	emp.setEmployeeId(123);
	emp.setEmpName("Sprint");
	emp.setPassword("this.123");
	emp.setRole(Role.admin);
	Mockito.when(trainerRepo.save(emp)).thenReturn(emp);
	assertThat(trainerService.addTrainer(emp)).isEqualTo(emp);
	}
	

	@Test
	public void testUpdateTrainer()
	{
		Employee emp = new Employee();
		emp.setEmployeeId(123);
		emp.setEmpName("Sprint");
		emp.setPassword("this.123");
		emp.setRole(Role.admin);
		
		Mockito.when(trainerRepo.findById(emp.getEmployeeId())).thenReturn(Optional.of(emp));
		emp.setEmpName("Angular");
		Mockito.when(trainerRepo.save(emp)).thenReturn(emp);
		
		assertThat(trainerService.updateTrainer(emp)).isEqualTo(emp);
	}
	@Test
	public void testRemoveTrainer()
	{
		Employee emp = new Employee();
		emp.setEmployeeId(123);
		emp.setEmpName("Sprint");
		emp.setPassword("this.123");
		emp.setRole(Role.admin);
		
		Mockito.when(trainerRepo.findById(emp.getEmployeeId())).thenReturn(Optional.of(emp));
	    Mockito.when(trainerRepo.existsById(emp.getEmployeeId())).thenReturn(false);
	   assertFalse(trainerRepo.existsById(emp.getEmployeeId()));
	}
	@Test
	public void viewTrainer()
	{
		Employee emp = new Employee();	
		emp.setEmployeeId(123);
		emp.setEmpName("Sprint");
		emp.setPassword("this.123");
		emp.setRole(Role.admin);
		Mockito.when(trainerRepo.findById(emp.getEmployeeId())).thenReturn(Optional.of(emp));
		assertThat(trainerService.viewTrainer(emp.getEmployeeId())).isEqualTo(emp);
	}
	@Test
	public void viewAllTrainers()
	{
		Employee emp1 = new Employee();	
		emp1.setEmployeeId(123);
		emp1.setEmpName("Sprint");
		emp1.setPassword("this.123");
		emp1.setRole(Role.admin);
		
		Employee emp2 = new Employee();
		emp2.setEmployeeId(124);	
		emp2.setEmpName("Sprint1");
		emp2.setPassword("this.124");
		emp2.setRole(Role.admin);
		List<Employee> addList = new ArrayList<>();
		addList.add(emp1); addList.add(emp2);
		
		Mockito.when(trainerRepo.findAll()).thenReturn(addList);
		
		assertThat(trainerService.viewAllTrainers()).isEqualTo(addList);
	}
	
}
