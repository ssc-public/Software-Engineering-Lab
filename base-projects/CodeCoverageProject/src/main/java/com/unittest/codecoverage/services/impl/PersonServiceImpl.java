package com.unittest.codecoverage.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittest.codecoverage.exceptions.PersonException;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.models.validators.PersonValidator;
import com.unittest.codecoverage.repositories.PersonRepository;
import com.unittest.codecoverage.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonValidator validator;
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	public PersonServiceImpl() {
		this.validator = new PersonValidator();
	}

	@Override
	public Person insert(Person person) {
		validator.validate(person);
		return repository.insert(person);
	}

	@Override
	public void update(Person person) {
		validator.validate(person);
		repository.update(person);
	}

	@Override
	public Person get(String name) {
		if(validator.requiredName(name)) {
			throw new PersonException("Name is required"); 
		}
		return repository.get(name);
	}

	@Override
	public void delete(String name) {
		if(validator.requiredName(name)) {
			throw new PersonException("Name is required"); 
		}
		repository.delete(name);
	}

}
