package com.cg.fms.exceptions;

public class TrainerNotFoundException extends RuntimeException{
	
String msg;
	
	public TrainerNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}


}
