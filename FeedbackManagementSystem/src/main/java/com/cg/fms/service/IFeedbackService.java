package com.cg.fms.service;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;

@Service
public interface IFeedbackService {
	
	public Feedback addFeedback(Feedback fbb);
	
	public Feedback updateFeedback(Feedback fbb);
	
	public Feedback viewProgramFeedback(int id);
	

}
 