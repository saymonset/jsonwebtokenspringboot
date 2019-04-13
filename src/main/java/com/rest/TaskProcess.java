package com.rest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.flowable.dmn.api.DmnRuleService;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CompletTask;
import com.service.MyService;

@RestController
@RequestMapping("/flowable/task")
public class TaskProcess {
	Logger log = LoggerFactory.getLogger(this.getClass().getName()); 
	@Autowired
    private DmnRuleService ruleService;
	 
    
    @Autowired
	 private MyService myService;
    
    
    @RequestMapping(value="/complete", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public  List<Map<String, Object>> startProcessInstance(@RequestBody CompletTask completTask) {
    	List<Task> taskList  = myService.taskProcess(completTask); 
    	List<Map<String, Object>> customTaskList = new ArrayList<>();
        for (Task task : taskList) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("taskId", task.getId());
            map.put("taskDefinitionKey", task.getTaskDefinitionKey());
            map.put("taskName", task.getName());

            customTaskList.add(map);
        }
        return customTaskList;
    }
}
