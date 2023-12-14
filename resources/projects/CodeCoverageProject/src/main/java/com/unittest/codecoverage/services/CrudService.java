package com.unittest.codecoverage.services;

public interface CrudService <O, ID> {
	
	public O insert(O object);
	
	public void update(O object);
	
	public O get(ID id);
	
	public void delete(ID id);

}
