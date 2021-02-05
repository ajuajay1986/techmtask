package com.techm.student.exception;

public class SchoolNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SchoolNotFoundException(String id) {
        super("Could not find school with id: '" + id + "'");
    }
	
}
