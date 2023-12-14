package com.unittest.codecoverage.models.validators;

import java.util.ArrayList;
import java.util.List;

import com.unittest.codecoverage.exceptions.PersonException;
import com.unittest.codecoverage.models.Person;

public class PersonValidator {
	
	public boolean requiredName(Person person) {
		return person != null && person.getName() != null && person.getName().trim().length() > 0;
	}
	
	public boolean requiredName(String name) {
		return name != null && name.trim().length() > 0;
	}
	
	public boolean requiredGender(Person person) {
		return person != null && person.getGender() != null;
	}
	
	public void validate(Person person) {
		List<String> errors = new ArrayList<>();
		if(!requiredName(person)) {
			errors.add("Name is required");
		}
		
		if(!requiredGender(person)) {
			errors.add("Gender is required");
		}
		
		if (!errors.isEmpty()) {
			throw new PersonException(errors);
		}
	}
	
}
