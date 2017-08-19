package com.saldivar.quartz.scheduler;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.saldivar.quartz.repository.DataRepository;

/**
 * Simple quartz job simulating a job which takes a long time to complete.
 * Writes the process into the database, start and finish.
 * For simplicity calling a repository instead of service.
 * {@link DisallowConcurrentExecution}: 
 * 		so the job doesn't run concurrently
 * 
 * @author saldivar
 *
 */
@DisallowConcurrentExecution
public class UpdatingRecordsJob implements Job {

	private DataRepository dataRepository;
	
	@Autowired
	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("Starting updatingRecordsJob. Total count of messages: " + dataRepository.getCount());
		dataRepository.insertMessage("Starting job at: " + new Date());
		
		processForSeveralMinutes();
		
		dataRepository.insertMessage("Finishing job at: " + new Date());
		System.out.println("Finishing updatingRecordsJob. Total count of messages: " + dataRepository.getCount());

		
	}

	private void processForSeveralMinutes() {
		
		System.out.println("processing...");
		long minutes = 2;
		
		try {
			Thread.sleep(minutes * 60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
