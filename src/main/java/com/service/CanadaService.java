package com.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.StartProcessRepresentation;
import com.model.Person;
import com.repository.PersonRepository;

@Service
public class CanadaService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private PersonRepository personRepository;

   
    
    
    public void startProcess(StartProcessRepresentation startProcessRepresentation) {

        Person person = personRepository.findByUsername(startProcessRepresentation.getAssignee());

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        variables.put("format", startProcessRepresentation.getFormat());
        variables.put("accurancy", startProcessRepresentation.getAccurancy());
        runtimeService.startProcessInstanceByKey("myProcess", variables);
    }

    
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

   

    @Transactional
    public void startProcess(Map<String,Object> var) {
        runtimeService.startProcessInstanceByKey("myProcess", var);
        
    }
 

}