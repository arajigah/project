package com.catalyst.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.project.entities.EnclosureCondition;
import com.catalyst.project.services.EnclosureConditionService;

@RestController
public class EnclosureConditionController {
	
	@Autowired
	EnclosureConditionService enclosureConditionService;
	
	@RequestMapping(value = "/enclosureCondition", method = RequestMethod.GET)
	public List<EnclosureCondition> getEnclosureConditions(){
		return enclosureConditionService.getEnclosureConditions();
	}
}
