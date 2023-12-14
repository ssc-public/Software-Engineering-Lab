package com.unittest.codecoverage.exceptions;

import java.util.ArrayList;
import java.util.List;

public class PersonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private List<String> errors = new ArrayList<>();
	
	public PersonException(String msg) {
		super(msg);
		this.errors.add(msg);
	}
	
	public PersonException(List<String> errors) {
		super(errors != null && !errors.isEmpty()? String.join(";", errors) : null);
		this.errors = errors;
	}

}
