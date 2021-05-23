package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Program;
import com.cg.fms.service.ITrainingProgramService;

@RestController
@RequestMapping("Fms/api")
public class ProgramController {
	
	@Autowired
	ITrainingProgramService itp;
	
	@PostMapping("/Program")
	public Program createProgram(@RequestBody Program p)
	{
		return itp.createProgram(p);
	}
	
	@GetMapping("/ProgramView")
	public Program viewProgram(@RequestBody int p)
	{
		return itp.viewProgram(p);
	}
	
	@DeleteMapping("/ProgramRem")
	public Program deleteProgram(@RequestBody Program p)
	{
		return itp.removeProgram(p);
	}
	
	@GetMapping("/ProgramFac")
	public Program findProgramByFaculty(int empId)
	{
		return itp.viewAllProgramsByFaculty(empId);
	}
}
