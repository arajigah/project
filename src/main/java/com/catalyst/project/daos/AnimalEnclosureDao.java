package com.catalyst.project.daos;

import java.util.List;

import com.catalyst.project.entities.AnimalEnclosure;

/**
 * Animal Enclosure DAO interface.
 * 
 * @author cmiller
 */
public interface AnimalEnclosureDao {

	/**
	 * 
	 * Gets a list of all the Animal Enclosures from the Database
	 * 
	 * @return List <AnimalEnclosure>
	 * @author cmiller
	 */
	List<AnimalEnclosure> getAllAnimalEnclosures();

	/** 
	 * Adds the Animal Enclosure to the Database
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	void addAnimalEncolsure(AnimalEnclosure animalEnclosure);

	/**
	 * Updates and existing AnimalEnclosure in the Database
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	void updateAnimalEncolsure(AnimalEnclosure animalEnclosure);

	/**
	 * Gets a Enclosure by id then removes it from the Database
	 * 
	 * @param Integer animaleEnclosureId
	 * @author cmiller
	 */
	void deleteAnimalEnclosure(Integer enclosureId);

	/**
	 * Gets an Animal Enclosre by its id from the Database
	 * 
	 * @param Integer animalEnclosureId
	 * @return AnimalEnclosure
	 * @author cmiller
	 */
	AnimalEnclosure getEnclosureById(Integer enclosureId);

}
