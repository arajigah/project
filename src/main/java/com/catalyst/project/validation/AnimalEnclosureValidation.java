package com.catalyst.project.validation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.catalyst.project.entities.AnimalEnclosure;

@Service
public class AnimalEnclosureValidation {

	public boolean validateAnimalEnclosure(AnimalEnclosure animalEnclosure) throws Exception{
		return validateAnimalEnclosureName(animalEnclosure) && validateNumberOfAnimals(animalEnclosure) && validateFeedingTime(animalEnclosure) 
				&& validateEnclosureCondition(animalEnclosure);
	}

	private boolean validateEnclosureCondition(AnimalEnclosure animalEnclosure) throws Exception {
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

	private boolean validateFeedingTime(AnimalEnclosure animalEnclosure) throws Exception {
		try{
			Date feedingTime = animalEnclosure.getFeedingTime();
			if(feedingTime != null){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			throw new Exception("Feeding Time is null");
		}
	}

	private boolean validateNumberOfAnimals(AnimalEnclosure animalEnclosure) {
		int numberOfAnimals = animalEnclosure.getNumberOfAnimals();
		if(numberOfAnimals > 0){
			return true;
		}
		else{
			return false;
		}
	}

	private boolean validateAnimalEnclosureName(AnimalEnclosure animalEnclosure) throws Exception {
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
