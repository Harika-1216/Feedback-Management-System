package com.cg.fms.exceptions;

public class ProgramNotFoundException extends RuntimeException{
	
String msg;
	
	public ProgramNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}


}
