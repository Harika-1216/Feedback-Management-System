package com.cg.fms.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Feedback {
	
	@Id
	private int Feedback_Id;
	
	
	@OneToOne
	@JoinColumn(name="trainingId")
	private Program program;
	
	private int feedbackCriteria1;
	private int feedbackCriteria2;
	private int feedbackCriteria3;
	private int feedbackCriteria4;
	private int feedbackCriteria5;
	private String comments;
	private String suggestions;
	
	public int getFeedback_Id() {
		return Feedback_Id;
	}
	public void setFeedback_Id(int feedback_Id) {
		Feedback_Id = feedback_Id;
	}
	
	public Program getProgram() {
		return program;
	}
	
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public int getFeedbackCriteria1() {
		return feedbackCriteria1;
	}
	public void setFeedbackCriteria1(int feedbackCriteria1) {
		this.feedbackCriteria1 = feedbackCriteria1;
	}
	public int getFeedbackCriteria2() {
		return feedbackCriteria2;
	}
	public void setFeedbackCriteria2(int feedbackCriteria2) {
		this.feedbackCriteria2 = feedbackCriteria2;
	}
	public int getFeedbackCriteria3() {
		return feedbackCriteria3;
	}
	public void setFeedbackCriteria3(int feedbackCriteria3) {
		this.feedbackCriteria3 = feedbackCriteria3;
	}
	public int getFeedbackCriteria4() {
		return feedbackCriteria4;
	}
	public void setFeedbackCriteria4(int feedbackCriteria4) {
		this.feedbackCriteria4 = feedbackCriteria4;
	}
	public int getFeedbackCriteria5() {
		return feedbackCriteria5;
	}
	public void setFeedbackCriteria5(int feedbackCriteria5) {
		this.feedbackCriteria5 = feedbackCriteria5;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	
	

}
