package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.StartProcessRepresentation;
import com.service.MyService;

 

@RestController
@RequestMapping("/flowable")
public class StartProcess {
	 @Autowired
	 private MyService myService;
	 
	@RequestMapping(value="/process", method= RequestMethod.POST)
    public void startProcessInstance(@RequestBody StartProcessRepresentation startProcessRepresentation) {
        myService.startProcess(startProcessRepresentation);
    }
	

}
