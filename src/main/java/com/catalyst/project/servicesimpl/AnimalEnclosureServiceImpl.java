package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.services.AnimalEnclosureService;
import com.catalyst.project.validation.AnimalEnclosureValidation;

/**
 * Animal Enclosure Serive class. Calls Validation methods to validate Enclosures on adding and updating.
 * 
 * @author cmiller
 */
@Service
public class AnimalEnclosureServiceImpl implements AnimalEnclosureService {

	@Autowired
	AnimalEnclosureDao animalEnclosureDao;
	
	@Autowired
	AnimalEnclosureValidation animalEnclosureValidation;
	
	/**
	 * 
	 * Gets a list of all the Animal Enclosures
	 * 
	 * @return List <AnimalEnclosure>
	 * @author cmiller
	 */
	@Override
	public List<AnimalEnclosure> getAllAnimalEnclosures() {
		return animalEnclosureDao.getAllAnimalEnclosures(); 
	}

	/** 
	 * Calls validation methods and if valid sends the enclosure to the DAO to be persisted
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	@Override
	public void addAnimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception {
		try{
			if(animalEnclosureValidation.validateAnimalEnclosure(animalEnclosure)){
				animalEnclosureDao.addAnimalEncolsure(animalEnclosure);
			}
			else{
				throw new Exception("Animal Enclosure Not Valid");
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}		
	}


	/**
	 * Calls validation methods and if valid sends the enclosure to the DAO to be updated
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	@Override
	public void updateAnaimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception {
		try{
			if(animalEnclosureValidation.validateAnimalEnclosure(animalEnclosure)){
				animalEnclosureDao.updateAnimalEncolsure(animalEnclosure);
			}
			else{
				throw new Exception("Animal Enclosure Not Valid");
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Sends an id to the DAO to delete an Animal Enclosure
	 * 
	 * @param Integer animaleEnclosureId
	 * @author cmiller
	 */
	@Override
	public void deleteAnimalEnclosure(Integer enclosureId) {
		animalEnclosureDao.deleteAnimalEnclosure(enclosureId);
		
	}
	
	/**
	 * Gets an Animal Enclosre by its id
	 * 
	 * @param Integer animalEnclosureId
	 * @return AnimalEnclosure
	 * @author cmiller
	 */
	@Override
	public AnimalEnclosure getAnimalEnclosureById(Integer enclosureId) {
		return animalEnclosureDao.getEnclosureById(enclosureId);
	}

	public void setAnimalEnclosureDao(AnimalEnclosureDao animalEnclosureDao) {
		this.animalEnclosureDao = animalEnclosureDao;
	}

	public void setAnimalEnclosureValidation(AnimalEnclosureValidation animalEnclosureValidation) {
		this.animalEnclosureValidation = animalEnclosureValidation;
	}

}
