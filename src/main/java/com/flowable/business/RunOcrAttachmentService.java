package com.flowable.business;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunOcrAttachmentService implements JavaDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void execute(DelegateExecution execution) {
		String executionId = execution.getProcessInstanceId();
		log.info( " = RUN OCR------------------------3--------------------------------executionId = " + execution.getProcessInstanceId());

		
	}

}
