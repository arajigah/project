package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalDao;
import com.catalyst.project.entities.Animal;
import com.catalyst.project.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{

	@Autowired
	AnimalDao animalDao;
	
	@Override
	public List<Animal> getAllAnimals() {
		return animalDao.getAllAnimals();
	}

}
