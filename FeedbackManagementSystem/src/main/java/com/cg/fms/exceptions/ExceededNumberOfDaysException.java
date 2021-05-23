package com.cg.fms.exceptions;

public class ExceededNumberOfDaysException extends RuntimeException{
	
String msg;
	
	public ExceededNumberOfDaysException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}

}
