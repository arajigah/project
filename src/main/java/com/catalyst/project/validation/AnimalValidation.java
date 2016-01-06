package com.catalyst.project.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.AnimalDao;
import com.catalyst.project.daos.FavoriteFoodDao;
import com.catalyst.project.entities.Animal;
import com.catalyst.project.entities.FavoriteFood;

@Service
public class AnimalValidation {

	@Autowired 
	AnimalDao animalDao;
	
	@Autowired
	FavoriteFoodDao favoriteFoodDao;
	
	public boolean validateAnimal(Animal animal) throws Exception{
		return validateAnimalName(animal) && validateScientificName(animal) && validateFavoriteFood(animal) 
				&& validateInformationalLink(animal);
	}
	
	public boolean validateAnimalName(Animal animal) throws Exception{
		try{
			boolean result = false;
			String animalName = animal.getAnimalName().trim();
			int animalId = animal.getAnimalId();
			if(!animalName.equals("")){
				result = true;
			}
			else{
				throw new Exception("Animal Name is Empty");
			}
			List<Animal> existingAnimals = animalDao.getAllAnimals();
			for(Animal a : existingAnimals){
				String existingAnimalName = a.getAnimalName();
				int existingAnimalId = a.getAnimalId();
				if(animalName.equals(existingAnimalName) && animalId != existingAnimalId){
					result = false;
					throw new Exception("Animal Name is already in use");
				}
			}
			return result;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean validateScientificName(Animal animal) throws Exception{
		try{
			boolean result = false;
			String scientificName = animal.getScientificName().trim();
			if(!scientificName.equals("")){
				result = true;
			}
			else{
				throw new Exception("Scientific Name is Empty");
			}
			return result;
		}catch(Exception e){
			throw new Exception ("Scientific Name is Null");
		}
	}
	
	public boolean validateFavoriteFood(Animal animal) throws Exception{
		boolean result = false;
		int foodId = animal.getFavoriteFood().getFavoriteFoodId();
		List<FavoriteFood> existingFoods = favoriteFoodDao.getAllFoods();
		for(FavoriteFood f : existingFoods){
			int existingFoodId = f.getFavoriteFoodId();
			if(foodId == existingFoodId){
				result = true;
			}
		}
		if(result == false){
			throw new Exception ("Food Does Not Exist");
		}
		return result;
	}
	
	public boolean validateInformationalLink(Animal animal) throws Exception{
		try{
			boolean result = false;
			String link = animal.getInformationalLink().trim();
			if((!link.equals("")&& link.contains("."))){
				result = true;
			}
			if(result == false){
				throw new Exception("Informational Link is Not Valid");
			}
			return result;
		}catch(Exception e){
			throw new Exception("Informational Link is Null");
		}
	}
}
