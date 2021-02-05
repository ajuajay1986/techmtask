package com.techm.student.exception;

public class StudentNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String isbn) {
        super("Could not find student with id: '" + isbn + "'");
    }
	
}
