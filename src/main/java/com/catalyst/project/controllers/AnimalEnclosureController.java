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

/**
 * Animal Enclosure Controller class. Has end points for POST, PUT, DELETE, and GET.
 * 
 * @author cmiller
 */
@RestController
public class AnimalEnclosureController {

	
	@Autowired
	AnimalEnclosureService animalEnclosureService;
	
	/**
	 * GET 
	 * Gets a list of all the Animal Enclosures
	 * 
	 * @return List <AnimalEnclosure>
	 * @author cmiller
	 */
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.GET)
	public List<AnimalEnclosure> getAllAnimalEnclosures(){
		return animalEnclosureService.getAllAnimalEnclosures();
	}
	
	/**
	 * GET 
	 * Gets an Animal Enclosre by its id
	 * 
	 * @param Integer animalEnclosureId
	 * @return AnimalEnclosure
	 * @author cmiller
	 */
	@RequestMapping(value = "/animalEnclosure/{enclosureId}", method = RequestMethod.GET)
	public AnimalEnclosure getAnimalEnclosureById(@PathVariable Integer enclosureId){
		return animalEnclosureService.getAnimalEnclosureById(enclosureId);
	}
	
	/**
	 * POST 
	 * Sends a AnimalEnclosure through the layers to be persisted
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.POST)
	public void addAnimalEnclosure(@RequestBody AnimalEnclosure animalEnclosure) throws Exception{
		try{
			animalEnclosureService.addAnimalEnclosure(animalEnclosure);
		}catch(Exception e){
			throw new Exception (e.getMessage());
		}
	}
	
	/**
	 * PUT 
	 * Sends a AnimalEnclosure through the layers to be updated
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	@RequestMapping(value = "/animalEnclosure", method = RequestMethod.PUT)
	public void updateAnimalEnclosure(@RequestBody AnimalEnclosure animalEnclosure) throws Exception{
		try{
			animalEnclosureService.updateAnaimalEnclosure(animalEnclosure);
		}catch(Exception e){
			throw new Exception (e.getMessage());
		}
	}
	
	/**
	 * DELETE 
	 * Sends an id to the DAO to delete an Animal Enclosure
	 * 
	 * @param Integer animaleEnclosureId
	 * @author cmiller
	 */
	@RequestMapping(value = "/animalEnclosure/{enclosureId}", method = RequestMethod.DELETE)
	public void deleteAnimalEnclosure(@PathVariable Integer enclosureId) {
		animalEnclosureService.deleteAnimalEnclosure(enclosureId);
	}
}
