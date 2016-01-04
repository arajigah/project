package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.services.AnimalEnclosureService;

@Service
public class AnimalEnclosureServiceImpl implements AnimalEnclosureService {

	@Autowired
	AnimalEnclosureDao animalEnclosureDao;
	
	@Override
	public List<AnimalEnclosure> getAllAnimalEnclosures() {
		return animalEnclosureDao.getAllAnimalEnclosures(); 
	}

	@Override
	public void addAnimalEnclosure(AnimalEnclosure animalEnclosure) {
		animalEnclosureDao.addAnimalEncolsure(animalEnclosure);
		
	}

	@Override
	public void updateAnaimalEnclosure(AnimalEnclosure animalEnclosure) {
		animalEnclosureDao.updateAnimalEncolsure(animalEnclosure);		
	}

	@Override
	public void deleteAnimalEnclosure(Integer enclosureId) {
		animalEnclosureDao.deleteAnimalEnclosure(enclosureId);
		
	}

}
