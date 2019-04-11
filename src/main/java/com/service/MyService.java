package com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.dmn.api.DmnRuleService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Person;
import com.repository.PersonRepository;

@Service
public class MyService {


	
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private PersonRepository personRepository;

   
    
    
    public void startProcess(String assignee) {

    	Person person = personRepository.findByUsername(assignee);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("myProcess", variables);
    }

    
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    public void createDemoUsers() {
        if (personRepository.findAll().size() == 0) {
            personRepository.save(new Person("jbarrez", "Joram", "Barrez", new Date()));
            personRepository.save(new Person("trademakers", "Tijs", "Rademakers", new Date()));
            personRepository.save(new Person("rsimon", "Simon", "Rodriguez", new Date()));
        }
    }

    @Transactional
    public void startProcess(Map<String,Object> var) {
        runtimeService.startProcessInstanceByKey("myProcess", var);
        
    }
 

}