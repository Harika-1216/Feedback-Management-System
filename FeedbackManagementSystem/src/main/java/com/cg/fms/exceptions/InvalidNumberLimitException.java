package com.cg.fms.exceptions;

public class InvalidNumberLimitException extends RuntimeException{
	
String msg;
	
	public InvalidNumberLimitException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}

}
