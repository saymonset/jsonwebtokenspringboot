package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.dmn.api.DmnRuleService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CompletTask;
import com.dto.StartProcessRepresentation;
import com.model.Person;
import com.model.ProcessInstanceFlow;
import com.repository.PersonRepository;
import com.repository.ProcessInstanceFlowRepository;

@Service
public class MyService {

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

	public void startProcess(StartProcessRepresentation startProcessRepresentation) {

		Person person = personRepository.findByUsername(startProcessRepresentation.getAssignee());

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("person", person);
		variables.put("format", startProcessRepresentation.getFormat());
		variables.put("accurancy", startProcessRepresentation.getAccurancy());

		ProcessInstance p = runtimeService.startProcessInstanceByKey("michaelCenizaProcess", variables);
		ProcessInstanceFlow p1 = new ProcessInstanceFlow();
		p1.setProcessInstanceId(p.getProcessInstanceId());
		p1.setPerson(person);
		processInstanceFlowRepository.save(p1);
	}

	public List<Task> taskProcess(CompletTask completTask) {

		List<Task> tasks1 = new  ArrayList();
		Person person = personRepository.findByUsername(completTask.getAssignee());
		List<ProcessInstanceFlow> list = processInstanceFlowRepository.getProcessInstanceFlow(person.getId());
		if (list != null && !list.isEmpty()) {
			log.info("-list tasks.size() = " + list.size());
			list.forEach(pif ->{
				log.info("-completTask.getAssignee() = " + completTask.getAssignee());
				List<Task>  tasks = taskService.createTaskQuery().taskCandidateGroup(completTask.getAssignee())
						.processInstanceId(pif.getProcessInstanceId()).list();

				if (null != tasks) {
					tasks.forEach(t -> {
						boolean approved = true;
						Map<String, Object> variables = new HashMap<String, Object>();
						variables.put("approved", approved);
						taskService.complete(t.getId(), variables);
						tasks1.add(t);
						log.info("---------------------approved task--------------------- = " + t.getName());
					});
				}
			});
			
			
		}
     return tasks1;
	}

	public void createDemoUsers() {
		if (personRepository.findAll().size() == 0) {
			personRepository.save(new Person("managers", "managers", "managers", new Date()));
		}
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
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