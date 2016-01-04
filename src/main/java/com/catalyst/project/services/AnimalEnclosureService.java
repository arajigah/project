package com.catalyst.project.services;

import java.util.List;

import com.catalyst.project.entities.AnimalEnclosure;

public interface AnimalEnclosureService {

	List<AnimalEnclosure> getAllAnimalEnclosures();

	void addAnimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception;

	void updateAnaimalEnclosure(AnimalEnclosure animalEnclosure);

	void deleteAnimalEnclosure(Integer enclosureId);
}
