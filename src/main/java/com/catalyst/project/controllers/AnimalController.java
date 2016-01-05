package com.catalyst.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.project.entities.Animal;
import com.catalyst.project.services.AnimalService;

@RestController
public class AnimalController {

	@Autowired
	AnimalService animalService;
	
	@RequestMapping(value = "/animal", method = RequestMethod.GET)
	public List<Animal> getAllAnimals(){
		return animalService.getAllAnimals();
	}
}
