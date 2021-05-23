package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.service.IFeedbackService;

@RestController
@RequestMapping("Fms/api")
public class FeedbackController {
	
	@Autowired
	IFeedbackService ibf;
	
	@PostMapping("/Feedback")
	public Feedback addFeedback(@RequestBody Feedback fbb)
	{
		return ibf.addFeedback(fbb);
	}
	
	@PostMapping("/FeedbackUp")
	public Feedback updateFeedback(@RequestBody Feedback fbb)
	{
		return ibf.updateFeedback(fbb);
	}
	
	@GetMapping("/FeedbackTr")
	public Feedback viewtrainerFeedback(int id)
	{
		return ibf.viewProgramFeedback(id);
	}
	

	

}
