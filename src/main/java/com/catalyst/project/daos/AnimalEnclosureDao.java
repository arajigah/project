package com.catalyst.project.daos;

import java.util.List;

import com.catalyst.project.entities.AnimalEnclosure;

public interface AnimalEnclosureDao {

	List<AnimalEnclosure> getAllAnimalEnclosures();

	void addAnimalEncolsure(AnimalEnclosure animalEnclosure);

	void updateAnimalEncolsure(AnimalEnclosure animalEnclosure);

	void deleteAnimalEnclosure(Integer enclosureId);

}
