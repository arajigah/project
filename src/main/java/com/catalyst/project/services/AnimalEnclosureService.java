package com.catalyst.project.services;

import java.util.List;

import com.catalyst.project.entities.AnimalEnclosure;

/**
 * Animal Enclosure Service interface.
 * 
 * @author cmiller
 */
public interface AnimalEnclosureService {

	/**
	 * 
	 * Gets a list of all the Animal Enclosures
	 * 
	 * @return List <AnimalEnclosure>
	 * @author cmiller
	 */
	List<AnimalEnclosure> getAllAnimalEnclosures();

	/** 
	 * Calls validation methods and if valid sends the enclosure to the DAO to be persisted
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	void addAnimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception;

	/**
	 * Calls validation methods and if valid sends the enclosure to the DAO to be updated
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	void updateAnaimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception;

	/**
	 * Sends an id to the DAO to delete an Animal Enclosure
	 * 
	 * @param Integer animaleEnclosureId
	 * @author cmiller
	 */
	void deleteAnimalEnclosure(Integer enclosureId);

	/**
	 * Gets an Animal Enclosre by its id
	 * 
	 * @param Integer animalEnclosureId
	 * @return AnimalEnclosure
	 * @author cmiller
	 */
	AnimalEnclosure getAnimalEnclosureById(Integer enclosureId);
}
