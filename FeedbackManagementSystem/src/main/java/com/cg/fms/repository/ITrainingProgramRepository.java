package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.fms.entities.Program;
import java.util.*;

public interface ITrainingProgramRepository extends JpaRepository<Program,Integer>{

	@Query("SELECT p from Program p WHERE p.faculty.employeeId=:employeeId")
	public Program viewAllProgramsByFaculty(@Param("employeeId") int empId);
}
