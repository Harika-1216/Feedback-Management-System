package com.cg.fms.exceptions;

public class IncorrectNameAndRoleException extends RuntimeException{
	
String msg;
	
	public IncorrectNameAndRoleException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}


}
