package com.cg.fms.exceptions;

public class FeedbackNotFoundException extends RuntimeException {
	
String msg;
	
	public FeedbackNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}

}
