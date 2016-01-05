package com.catalyst.project.validationtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.project.entities.Animal;
import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.entities.EnclosureCondition;
import com.catalyst.project.validation.AnimalEnclosureValidation;

public class AnimalEnclosureValidationTest {
	
	private AnimalEnclosureValidation target;
	
	@Before
	public void setup(){
		target = new AnimalEnclosureValidation();
	}
	
	@Test
	public void testValidateAnimalEnclosureWithValidEnclosure() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		Animal animal = new Animal();
		animal.setAnimalId(1);
		Date time = new Date();
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("Name");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(time);
		enclosure.setNumberOfAnimals(12);
		
		assertTrue(target.validateAnimalEnclosure(enclosure));
	}
	
	@Test
	public void testValidateAnimalEnclosureWithInvalidEnclosureCondition() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("");
		Animal animal = new Animal();
		animal.setAnimalId(1);
		Date time = new Date();
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("Name");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(time);
		enclosure.setNumberOfAnimals(12);
		
		assertFalse(target.validateAnimalEnclosure(enclosure));
	}
	@Test
	public void testValidateAnimalEnclosureWithInvalidAnimal() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		Animal animal = new Animal();
		animal.setAnimalId(0);
		Date time = new Date();
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("Name");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(time);
		enclosure.setNumberOfAnimals(12);
		
		assertFalse(target.validateAnimalEnclosure(enclosure));
	}
	@Test
	public void testValidateAnimalEnclosureWithInvalidFeedingTime() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		Animal animal = new Animal();
		animal.setAnimalId(1);
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("Name");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(null);
		enclosure.setNumberOfAnimals(12);
		
		assertFalse(target.validateAnimalEnclosure(enclosure));
	}
	@Test
	public void testValidateAnimalEnclosureWithInvalidNumberOfAnimals() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		Animal animal = new Animal();
		animal.setAnimalId(1);
		Date time = new Date();
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("Name");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(time);
		enclosure.setNumberOfAnimals(0);
		
		assertFalse(target.validateAnimalEnclosure(enclosure));
	}
	@Test
	public void testValidateAnimalEnclosureWithInvalidName() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		Animal animal = new Animal();
		animal.setAnimalId(1);
		Date time = new Date();
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimal(animal);
		enclosure.setAnimalEnclosureName("");
		enclosure.setEnclosureCondition(condition);
		enclosure.setFeedingTime(time);
		enclosure.setNumberOfAnimals(0);
		
		assertFalse(target.validateAnimalEnclosure(enclosure));
	}
	@Test
	public void testValidateEnclosureConditionWithValidCondition() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("condition");
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setEnclosureCondition(condition);
		
		assertTrue(target.validateEnclosureCondition(enclosure));
	}
	@Test
	public void testValidateEnclosureConditionWithEmptyCondition() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition("");
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setEnclosureCondition(condition);
		
		assertFalse(target.validateEnclosureCondition(enclosure));
	}
	@Test(expected=Exception.class)
	public void testValidateEnclosureConditionWithNullCondition() throws Exception{
		EnclosureCondition condition = new EnclosureCondition();
		condition.setEnclosureCondition(null);
		
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setEnclosureCondition(condition);
		
		assertFalse(target.validateEnclosureCondition(enclosure));
	}
	
	@Test
	public void testValidateEnclosureNameWithValidName() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimalEnclosureName("name");
		
		assertTrue(target.validateAnimalEnclosureName(enclosure));
	}
	@Test
	public void testValidateEnclosureNameWithEmptyName() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimalEnclosureName("");
		
		assertFalse(target.validateAnimalEnclosureName(enclosure));
	}
	@Test(expected=Exception.class)
	public void testValidateEnclosureNameWithNullName() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setAnimalEnclosureName(null);
		
		target.validateAnimalEnclosureName(enclosure);
	}
	@Test
	public void testValidateFeedingTimeWithNullDate() {
		AnimalEnclosure enclosure = new AnimalEnclosure();
		enclosure.setFeedingTime(null);
		
		assertFalse(target.validateFeedingTime(enclosure));
	}
}
