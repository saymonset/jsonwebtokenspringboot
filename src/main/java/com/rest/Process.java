package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.StartProcessRepresentation;
import com.rules.Order;
import com.service.CanadaService;

 

@RestController
@RequestMapping("/flowable")
public class Process {
	 @Autowired
	 private CanadaService myService;
	 
	@RequestMapping(value="/process", method= RequestMethod.POST)
    public void startProcessInstance(@RequestBody StartProcessRepresentation startProcessRepresentation) {
        myService.startProcess(startProcessRepresentation);
    }
	
	@RequestMapping(value="/drl", method= RequestMethod.POST)
    public void drl(@RequestBody Order order) {
        myService.order(order);
    }
}
