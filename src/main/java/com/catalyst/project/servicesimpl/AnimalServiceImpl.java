package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalDao;
import com.catalyst.project.entities.Animal;
import com.catalyst.project.services.AnimalService;
import com.catalyst.project.validation.AnimalValidation;

@Service
public class AnimalServiceImpl implements AnimalService{

	@Autowired
	AnimalDao animalDao;
	
	@Autowired
	AnimalValidation animalValidation;
	
	@Override
	public List<Animal> getAllAnimals() {
		return animalDao.getAllAnimals();
	}

	@Override
	public Animal getAnimalById(Integer animalId) {
		return animalDao.getAnimalById(animalId);
	}

	@Override
	public void addAnimal(Animal animal) throws Exception {
		if(animalValidation.validateAnimal(animal)){
			animalDao.addAnimal(animal);
		}
	}

	@Override
	public void updateAnimal(Animal animal) throws Exception {
		if(animalValidation.validateAnimal(animal)){
			animalDao.updateAnimal(animal);
		}
	}

}
