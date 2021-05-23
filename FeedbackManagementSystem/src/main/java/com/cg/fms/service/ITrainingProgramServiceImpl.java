package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.fms.entities.Program;
import com.cg.fms.exceptions.ProgramNotFoundException;
import com.cg.fms.repository.ITrainingProgramRepository;

@Service
public class ITrainingProgramServiceImpl implements ITrainingProgramService{

	@Autowired
	ITrainingProgramRepository itp;
	
	
	@Override
	public Program createProgram(Program p) {
		itp.save(p);
		return p;
	}

	@Override
	public Program updateProgram(Program p) {
		itp.save(p);
		return p;
	}

	@Override
	public Program removeProgram(Program p) {
		Optional<Program> em= itp.findById(p.getTrainingId());
		itp.deleteById(p.getTrainingId());
		return em.get();
		
	}

	@Override
	public Program viewProgram(int p) throws ProgramNotFoundException{
		if(itp.findById(p) != null)
		{
		Optional<Program> em= itp.findById(p);
		return em.get();
		}
		else
		{
			throw new ProgramNotFoundException("Program does not exist");
		}
	}

	@Override
	public List<Program> viewAllPrograms() {
		List<Program> lst= itp.findAll();
		return lst;
	}

	@Override
	public Program viewAllProgramsByFaculty(int empid) {
		return itp.viewAllProgramsByFaculty(empid);
	}

	

}
