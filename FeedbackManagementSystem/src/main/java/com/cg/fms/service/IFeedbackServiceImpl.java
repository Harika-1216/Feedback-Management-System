package com.cg.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Course;
import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.exceptions.FeedbackNotFoundException;
import com.cg.fms.exceptions.InvalidNumberLimitException;
import com.cg.fms.repository.IFeedbackRepository;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class IFeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	IFeedbackRepository ifb;

	@Override
	public Feedback addFeedback(Feedback fbb) throws InvalidNumberLimitException {
		if(validate(fbb))
		{
		ifb.save(fbb);
		return fbb;
		}
		else
		{
			throw new InvalidNumberLimitException("Number allocated wa beyond the limits");
		}

	}

	@Override
	public Feedback updateFeedback(Feedback fbb) {
		ifb.save(fbb);
		return fbb;
	}

	@Override
	public Feedback viewProgramFeedback(int id) throws FeedbackNotFoundException {
	
		return ifb.viewTrainerFeedback(id);
			
	}

	public boolean validate(Feedback fbb)
	{
		int i=0;
		if(fbb.getFeedbackCriteria1()>0 && fbb.getFeedbackCriteria1()<10)
		{
			i=i+1;
		}
		if(fbb.getFeedbackCriteria2()>0 && fbb.getFeedbackCriteria2()<10)
		{
			i=i+1;
		}
		if(fbb.getFeedbackCriteria3()>0 && fbb.getFeedbackCriteria3()<10)
		{
			i=i+1;
		}
		if(fbb.getFeedbackCriteria4()>0 && fbb.getFeedbackCriteria4()<10)
		{
			i=i+1;
		}
		if(fbb.getFeedbackCriteria5()>0 && fbb.getFeedbackCriteria5()<10)
		{
			i=i+1;
		}
		if(i==5)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
