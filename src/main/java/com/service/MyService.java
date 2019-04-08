package com.service;

import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Transactional
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("myProcess");
        
    }

    @Transactional
    public void startProcess(Map<String,Object> var) {
        runtimeService.startProcessInstanceByKey("myProcess", var);
        
    }
    @Transactional
    public List<Task> getTasks(String assignee) {
   
    	return taskService.createTaskQuery().taskAssignee(assignee).list();
    	//TaskService taskService = runtimeService.getTaskService();
    	//return null;
    }

}