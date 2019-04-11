package com.flowable.mail;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseBill implements JavaDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	private org.flowable.engine.impl.el.FixedValue from;
	private org.flowable.engine.impl.el.FixedValue to;
	private org.flowable.engine.impl.el.JuelExpression subject;
	private org.flowable.engine.impl.el.JuelExpression html;

	@Override
	public void execute(DelegateExecution execution) {
		String executionId = execution.getProcessInstanceId();
		
		
		 
		log.info(execution.getVariable("format") + " = format-------------------------2---------------------------------executionId = " + executionId);

		
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public org.flowable.engine.impl.el.FixedValue getFrom() {
		return from;
	}

	public void setFrom(org.flowable.engine.impl.el.FixedValue from) {
		this.from = from;
	}

	public org.flowable.engine.impl.el.FixedValue getTo() {
		return to;
	}

	public void setTo(org.flowable.engine.impl.el.FixedValue to) {
		this.to = to;
	}

	  
	public org.flowable.engine.impl.el.JuelExpression getSubject() {
		return subject;
	}

	public void setSubject(org.flowable.engine.impl.el.JuelExpression subject) {
		this.subject = subject;
	}

	public org.flowable.engine.impl.el.JuelExpression getHtml() {
		return html;
	}

	public void setHtml(org.flowable.engine.impl.el.JuelExpression html) {
		this.html = html;
	}

	 

}
