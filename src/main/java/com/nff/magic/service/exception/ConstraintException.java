package com.nff.magic.service.exception;

public class ConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConstraintException() {
		super("The inserted card already exist");
	}

	
}
