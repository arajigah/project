package com.catalyst.project.daos;

import java.util.List;

import com.catalyst.project.entities.Animal;

public interface AnimalDao {

	List<Animal> getAllAnimals();

	Animal getAnimalById(Integer animalId);

	void addAnimal(Animal animal);

	void updateAnimal(Animal animal);

}
