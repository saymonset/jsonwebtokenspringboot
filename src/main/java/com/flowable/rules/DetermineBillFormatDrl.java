package com.flowable.rules;
import java.util.ArrayList;
import java.util.List;

import org.flowable.common.engine.api.delegate.Expression;
import  org.flowable.engine.delegate.BusinessRuleTaskDelegate;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.DelegateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DetermineBillFormatDrl  implements BusinessRuleTaskDelegate{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
    public static List<Expression> ruleInputVariables = new ArrayList<>();
    public static List<Expression> ruleIds = new ArrayList<>();
    public static Boolean exclude;
    public static String resultVariableName;
    
    

    @Override
    public void execute(DelegateExecution execution) {
    //	 List<ProcessInstanceFlow>  lista =  processInstanceFlowRepository.findAll();
    	log.info( " = por ahora-------------------------4--------------------------------executionId = " + execution.getProcessInstanceId());
       execution.setVariable("outputVariable1", false);
     //   execution.setVariable("test", false);
        DelegateHelper.leaveDelegate(execution);
    }

    @Override
    public void addRuleVariableInputIdExpression(Expression inputId) {
        ruleInputVariables.add(inputId);
    }

    @Override
    public void addRuleIdExpression(Expression inputId) {
        ruleIds.add(inputId);
    }

    @Override
    public void setExclude(boolean exclude) {
    	DetermineBillFormatDrl.exclude = exclude;
    }

    @Override
    public void setResultVariable(String resultVariableName) {
    	DetermineBillFormatDrl.resultVariableName = resultVariableName;
    }
}
