package com.service;
import org.flowable.common.engine.api.delegate.Expression;
import  org.flowable.engine.delegate.BusinessRuleTaskDelegate;
import org.flowable.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DetermineBillFormat implements BusinessRuleTaskDelegate{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	@Override
	public void execute(DelegateExecution execution) {
		log.info("Execute");
		log.info(execution.getVariable("format") + " = format-------------------------2---------------------------------executionId = " + execution.getProcessInstanceId());
		
	}

	@Override
	public void addRuleVariableInputIdExpression(Expression inputId) {
		log.info("addRuleVariableInputIdExpression");
		
	}

	@Override
	public void addRuleIdExpression(Expression inputId) {
		log.info("addRuleIdExpression");
		
	}

	@Override
	public void setExclude(boolean exclude) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResultVariable(String resultVariableName) {
		// TODO Auto-generated method stub
		
	}

}
