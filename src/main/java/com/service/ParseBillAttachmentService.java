package com.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseBillAttachmentService implements JavaDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void execute(DelegateExecution execution) {
		String executionId = execution.getProcessInstanceId();
		
		
		//log.info("Execute");
//		Order order = (Order)execution.getVariable("order");
		log.info( " = PARSE BILL-------------------------3--------------------------------executionId = " + execution.getProcessInstanceId());

		
	}

}
