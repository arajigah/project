package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.services.AnimalEnclosureService;
import com.catalyst.project.validation.AnimalEnclosureValidation;

@Service
public class AnimalEnclosureServiceImpl implements AnimalEnclosureService {

	@Autowired
	AnimalEnclosureDao animalEnclosureDao;
	
	@Autowired
	AnimalEnclosureValidation animalEnclosureValidation;
	
	@Override
	public List<AnimalEnclosure> getAllAnimalEnclosures() {
		return animalEnclosureDao.getAllAnimalEnclosures(); 
	}

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

	@Override
	public void deleteAnimalEnclosure(Integer enclosureId) {
		animalEnclosureDao.deleteAnimalEnclosure(enclosureId);
		
	}

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
