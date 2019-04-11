package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.dmn.api.DmnRuleService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.StartProcessRepresentation;
import com.model.Person;
import com.model.ProcessInstanceFlow;
import com.repository.PersonRepository;
import com.repository.ProcessInstanceFlowRepository;
import com.rules.Order;

@Service
public class CanadaService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName()); 
	@Autowired
    private DmnRuleService ruleService;
	
	
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private ProcessInstanceFlowRepository processInstanceFlowRepository;

   
    
    public void order(Order order) {
    	 Map<String, Object> variables = new HashMap<String, Object>();
    	 /*  Order order = new Order();
           order.setItemCount(2);
           variables.put("order", order);*/
    	 List<ProcessInstanceFlow>  lista =  processInstanceFlowRepository.findAll();
    	 ProcessInstanceFlow processInstanceFlow = lista.get(0);
    	 variables = runtimeService.getVariables(processInstanceFlow.getProcessInstanceId());
    	 
    	 variables  =  ruleService.createExecuteDecisionBuilder().decisionKey("simple")
    			 .variable("inputVariable1", 1).executeWithSingleResult();
    	 
 
    	//  ruleService.
    	 
    	 order = (Order)runtimeService.getVariable(processInstanceFlow.getProcessInstanceId(), "order");
    	 variables.forEach((k,v) -> System.out.println(k + " = k,, v =" + v));
    	// System.out.println("es valido = " + order.isValid());
    	        
    	        
    	        
    	        
    	    }
    
    
    public void startProcess(StartProcessRepresentation startProcessRepresentation) {

  /*      log.info((ruleService == null) + " = is nulo ruleService, " );
    	
   	 Map<String, Object> variables1 = new HashMap<>();
     variables1.put("inputVariable1", 1);
     Map<String, Object> result = ruleService.createExecuteDecisionBuilder().decisionKey("simple").variables(variables1).executeWithSingleResult();
     result.forEach((k, v) -> System.out.println((k + ":" + v.toString())));*/
        
        
        Person person = personRepository.findByUsername(startProcessRepresentation.getAssignee());

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        variables.put("inputVariable1", 1);
        variables.put("format", startProcessRepresentation.getFormat());
        variables.put("accurancy", startProcessRepresentation.getAccurancy());
        Order order = new Order();
        order.setItemCount(2);
        variables.put("order", order);
        ProcessInstance p = runtimeService.startProcessInstanceByKey("myProcess", variables);
        
      
        ProcessInstanceFlow p1 = new ProcessInstanceFlow();
        p1.setProcessInstanceId(p.getProcessInstanceId());
        processInstanceFlowRepository.save(p1); 
    }

    
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

   

    @Transactional
    public void startProcess(Map<String,Object> var) {
        runtimeService.startProcessInstanceByKey("myProcess", var);
        
    }


	public Logger getLog() {
		return log;
	}


	public void setLog(Logger log) {
		this.log = log;
	}


	public DmnRuleService getRuleService() {
		return ruleService;
	}


	public void setRuleService(DmnRuleService ruleService) {
		this.ruleService = ruleService;
	}


	public RuntimeService getRuntimeService() {
		return runtimeService;
	}


	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}


	public TaskService getTaskService() {
		return taskService;
	}


	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}


	public PersonRepository getPersonRepository() {
		return personRepository;
	}


	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
 

}