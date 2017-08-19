package com.saldivar.quartz.repository;

/**
 * Simple interface for get and updating records 
 * into the testing table.
 * 
 * @author saldivar
 *
 */
public interface DataRepository {

	int getCount();
	int insertMessage(String message);
	
}
