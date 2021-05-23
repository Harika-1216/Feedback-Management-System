package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.fms.entities.Feedback;


public interface IFeedbackRepository extends JpaRepository<Feedback, Integer>{

	@Query("SELECT f from Feedback f WHERE f.program.trainingId=:trainingId")
	public Feedback viewTrainerFeedback(@Param("trainingId") int id);
	
}
