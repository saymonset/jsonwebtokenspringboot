package com.service;


import org.flowable.engine.delegate.DelegateExecution;

import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillAttachmentService implements JavaDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void execute(DelegateExecution execution) {
		String executionId = execution.getProcessInstanceId();
		
		
		 
		log.info(execution.getVariable("format") + " = format-------------------------2---------------------------------executionId = " + executionId);

		
	}

}
