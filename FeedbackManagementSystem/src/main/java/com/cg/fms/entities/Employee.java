package com.cg.fms.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id
	private int employeeId;

	private String empName;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	

	@OneToOne(cascade=CascadeType.ALL,mappedBy="faculty")
	@JsonIgnore
	private Program prog;
	
	public Program getProg() {
		return prog;
	}
	public void setProg(Program prog) {
		this.prog = prog;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", password=" + password + ", role="
				+ role + "]";
	}
	
	

}
