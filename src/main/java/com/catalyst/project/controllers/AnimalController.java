package com.catalyst.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/animal/{animalId}", method = RequestMethod.GET)
	public Animal getAnimalById(@PathVariable Integer animalId){
		return animalService.getAnimalById(animalId);
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.POST)
	public void addAnimal(@RequestBody Animal animal) throws Exception{
		try{
			animalService.addAnimal(animal);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal animal) throws Exception{
		try{
			animalService.updateAnimal(animal);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
