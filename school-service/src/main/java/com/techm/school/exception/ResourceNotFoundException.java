package com.techm.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -858511896170834467L;

    public ResourceNotFoundException( String id) {
    	super("Could not find school with id: '" + id + "'");
    }



}
