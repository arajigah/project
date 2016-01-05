package com.catalyst.project.validation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.catalyst.project.entities.AnimalEnclosure;

@Service
public class AnimalEnclosureValidation {

	public boolean validateAnimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception{
		return validateAnimalEnclosureName(animalEnclosure) && validateNumberOfAnimals(animalEnclosure) && validateFeedingTime(animalEnclosure) 
				&& validateEnclosureCondition(animalEnclosure) && validateAnimal(animalEnclosure);
	}
	
	public boolean validateAnimal(AnimalEnclosure animalEnclosure){
		int animalId = animalEnclosure.getAnimal().getAnimalId();
		if(animalId > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean validateEnclosureCondition(AnimalEnclosure animalEnclosure) throws Exception {
		try{
			String enclosureCondition = animalEnclosure.getEnclosureCondition().getEnclosureCondition();
			if(!enclosureCondition.equals("")){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			throw new Exception("Enclosure Condition is null");
		}
	}

	public boolean validateFeedingTime(AnimalEnclosure animalEnclosure) {
			Date feedingTime = animalEnclosure.getFeedingTime();
			if(feedingTime != null){
				return true;
			}
			else{
				return false;
			}
	}

	public boolean validateNumberOfAnimals(AnimalEnclosure animalEnclosure) {
		int numberOfAnimals = animalEnclosure.getNumberOfAnimals();
		if(numberOfAnimals > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean validateAnimalEnclosureName(AnimalEnclosure animalEnclosure) throws Exception {
		try{
			String enclosureName = animalEnclosure.getAnimalEnclosureName().trim();
			if(!enclosureName.equals("")){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			throw new Exception("Enclosure Name is null");
		}
		
	}
}
