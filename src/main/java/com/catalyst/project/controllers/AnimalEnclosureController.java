package com.catalyst.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.services.AnimalEnclosureService;

@RestController
public class AnimalEnclosureController {

	@Autowired
	AnimalEnclosureService animalEnclosureService;
	
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.GET)
	public List<AnimalEnclosure> getAllAnimalEnclosures(){
		return animalEnclosureService.getAllAnimalEnclosures();
	}
	
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.POST)
	public void addAnimalEnclosure(@RequestBody AnimalEnclosure animalEnclosure) throws Exception{
		try{
			animalEnclosureService.addAnimalEnclosure(animalEnclosure);
		}catch(Exception e){
			throw new Exception (e.getMessage());
		}
	}
	
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.PUT)
	public void updateAnimalEnclosure(@RequestBody AnimalEnclosure animalEnclosure) throws Exception{
		try{
			animalEnclosureService.updateAnaimalEnclosure(animalEnclosure);
		}catch(Exception e){
			throw new Exception (e.getMessage());
		}
	}
	@RequestMapping(value = "/animalEnclosure/{enclosureId}", method = RequestMethod.DELETE)
	public void deleteAnimalEnclosure(@PathVariable Integer enclosureId) {
		animalEnclosureService.deleteAnimalEnclosure(enclosureId);
	}
}
