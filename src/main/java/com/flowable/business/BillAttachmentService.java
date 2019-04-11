package com.flowable.business;


import org.flowable.engine.delegate.DelegateExecution;

import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dto.Order;

public class BillAttachmentService implements JavaDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void execute(DelegateExecution execution) {
		String executionId = execution.getProcessInstanceId();
		
		
		//log.info("Execute");
//		Order order = (Order)execution.getVariable("order");
		log.info( " = format-------------------------3--------------------------------executionId = " + execution.getProcessInstanceId());

		
	}

}
