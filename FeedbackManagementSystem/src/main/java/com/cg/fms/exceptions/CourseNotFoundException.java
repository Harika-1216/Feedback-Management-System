package com.cg.fms.exceptions;

public class CourseNotFoundException extends RuntimeException{
	
String msg;
	
	public CourseNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}

}
