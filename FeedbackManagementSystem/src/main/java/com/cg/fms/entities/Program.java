package com.cg.fms.entities;
import java.beans.Transient;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Program {
	
	@Id
	private int trainingId;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	@OneToOne
	@JoinColumn(name ="courseId")
	private Course course;
	
	@OneToOne
	@JoinColumn(name ="employeeId")
	private Employee faculty;
	
	@OneToOne(mappedBy="program")
	@JsonIgnore
	private Feedback feedback;
	
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Employee getFaculty() {
		return faculty;
	}
	public void setFaculty(Employee faculty) {
		this.faculty = faculty;
	}
	
	@Override
	public String toString() {
		return "Program [trainingId=" + trainingId + ", startDate=" + startDate + ", endDate=" + endDate + ", course="
				+ course + ", faculty=" + faculty + "]";
	}
	
	
	

}
