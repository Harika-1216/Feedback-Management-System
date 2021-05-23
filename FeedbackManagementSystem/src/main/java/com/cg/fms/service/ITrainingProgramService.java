package com.cg.fms.service;

import com.cg.fms.entities.Program;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface ITrainingProgramService {
	
	public Program createProgram(Program p);
	
	public Program updateProgram(Program p);
	
	public Program removeProgram(Program p);
	
	public Program viewProgram(int p);
	
	public List<Program> viewAllPrograms();
	
	public Program viewAllProgramsByFaculty(int empid);

}
