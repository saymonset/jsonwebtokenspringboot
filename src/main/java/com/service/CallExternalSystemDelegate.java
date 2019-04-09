package com.service;

import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.variable.api.persistence.entity.VariableInstance;
import org.springframework.beans.factory.annotation.Autowired;

public class CallExternalSystemDelegate implements  TaskListener  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Autowired
    private RuntimeService runtimeService;
    
	public void execute(DelegateExecution execution) {
		System.out.println("-------------------------1---------------------------------");
	        System.out.println("Calling the external system for employee "
	            + execution.getVariable("format"));
	    }
	 
	 
		public void notify(DelegateTask delegateTask) {
			;
			String executionId = delegateTask.getProcessInstanceId();
			
			
	 
			System.out.println(delegateTask.getVariable("format") + " = format-------------------------2---------------------------------executionId = " + executionId);
			 // Execute custom identity lookups here

		    // and then for example call following methods:
		   /* delegateTask.setAssignee("kermit");
		    delegateTask.addCandidateUser("fozzie");
		    delegateTask.addCandidateGroup("management");*/
			
		}
}
