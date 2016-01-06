package com.catalyst.project.services;

import java.util.List;

import com.catalyst.project.entities.Animal;

public interface AnimalService {

	List<Animal> getAllAnimals();

	Animal getAnimalById(Integer animalId);

	void addAnimal(Animal animal) throws Exception;

	void updateAnimal(Animal animal) throws Exception;

}
