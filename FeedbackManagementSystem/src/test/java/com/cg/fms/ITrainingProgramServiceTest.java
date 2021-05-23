package com.cg.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.entities.Program;
import com.cg.fms.repository.ITrainingProgramRepository;
import com.cg.fms.service.ITrainingProgramService;


@SpringBootTest
public class ITrainingProgramServiceTest {
	@Autowired
	ITrainingProgramService programService;
	@MockBean
	ITrainingProgramRepository programRepo;
	@Test
	public void testCreateProgram()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));

		Mockito.when(programRepo.save(pro)).thenReturn(pro);
		assertThat(programService.createProgram(pro)).isEqualTo(pro);
	}
	@Test
	public void testUpdateProgram()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
Mockito.when(programRepo.findById(pro.getTrainingId())).thenReturn(Optional.of(pro));
		
		pro.setStartDate(LocalDate.of(2020, 2, 3));
		Mockito.when(programRepo.save(pro)).thenReturn(pro);
		
		assertThat(programService.updateProgram(pro)).isEqualTo(pro);
	}
	@Test
	public void testRemoveProgram()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Mockito.when(programRepo.findById(1)).thenReturn(Optional.of(pro));
	    Mockito.when(programRepo.existsById(pro.getTrainingId())).thenReturn(false);
	   assertFalse(programRepo.existsById(pro.getTrainingId()));
	}
	@Test
	public void testViewProgram()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Mockito.when(programRepo.findById(pro.getTrainingId())).thenReturn(Optional.of(pro));
		assertThat(programService.viewProgram(pro.getTrainingId())).isEqualTo(pro);
	}
	
	@Test
	public void testViewAllPrograms()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Program pro1= new Program();
		pro1.setTrainingId(456);
		pro1.setStartDate(LocalDate.of(2020,1,9));
		pro1.setEndDate(LocalDate.of(2020,1,29));
		List<Program> addList = new ArrayList<>();
		addList.add(pro); addList.add(pro1);
       Mockito.when(programRepo.findAll()).thenReturn(addList);
		
		assertThat(programService.viewAllPrograms()).isEqualTo(addList);
	}
	@Test
	public void testViewAllProgramsByFaculty()
	{
		Program pro= new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Program pro1= new Program();
		pro1.setTrainingId(456);
		pro1.setStartDate(LocalDate.of(2020,1,9));
		pro1.setEndDate(LocalDate.of(2020,1,29));
		List<Program> addList = new ArrayList<>();
		addList.add(pro); addList.add(pro1);
		Mockito.when(programRepo.viewAllProgramsByFaculty(123)).thenReturn(pro);
		assertThat(programService.viewAllProgramsByFaculty(123)).isEqualTo(pro);
	}

}