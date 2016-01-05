package com.catalyst.project.servicesimpltest;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;
import com.catalyst.project.servicesimpl.AnimalEnclosureServiceImpl;
import com.catalyst.project.validation.AnimalEnclosureValidation;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AnimcalEnclosureServiceImplTest {
	
	private AnimalEnclosureServiceImpl target;
	private AnimalEnclosureDao mockEnclosureDao;
	private AnimalEnclosureValidation mockEnclosureValidation;
	
	@Before
	public void setup(){
		target = new AnimalEnclosureServiceImpl();
		mockEnclosureDao = mock(AnimalEnclosureDao.class);
		mockEnclosureValidation = mock(AnimalEnclosureValidation.class);
		target.setAnimalEnclosureDao(mockEnclosureDao);
		target.setAnimalEnclosureValidation(mockEnclosureValidation);
	}
	
	@Test
	public void testAddEnclosureWhenValidationReturnsTrue() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		when(mockEnclosureValidation.validateAnimalEnclosure(enclosure)).thenReturn(true);
		target.addAnimalEnclosure(enclosure);
		verify(mockEnclosureDao, times(1)).addAnimalEncolsure(enclosure);
	}
	
	@Test(expected=Exception.class)
	public void testAddEnclosureWhenValidationReturnsFalse() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		when(mockEnclosureValidation.validateAnimalEnclosure(enclosure)).thenReturn(false);
		target.addAnimalEnclosure(enclosure);
	}
	
	@Test
	public void testGetAllEnclosures(){
		target.getAllAnimalEnclosures();
		verify(mockEnclosureDao, times(1)).getAllAnimalEnclosures();
	}
	
	@Test
	public void testUpdateEnclosureWhenValidationReturnsTrue() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		when(mockEnclosureValidation.validateAnimalEnclosure(enclosure)).thenReturn(true);
		target.updateAnaimalEnclosure(enclosure);
		verify(mockEnclosureDao, times(1)).updateAnimalEncolsure(enclosure);
	}
	
	@Test(expected=Exception.class)
	public void testUpdateEnclosureWhenValidationReturnsFalse() throws Exception{
		AnimalEnclosure enclosure = new AnimalEnclosure();
		when(mockEnclosureValidation.validateAnimalEnclosure(enclosure)).thenReturn(false);
		target.updateAnaimalEnclosure(enclosure);
	}
	
	@Test
	public void testDeleteEnclosure(){
		Integer enclosureId = 1;
		target.deleteAnimalEnclosure(enclosureId);
		verify(mockEnclosureDao, times(1)).deleteAnimalEnclosure(enclosureId);
		
	}
	
	@Test
	public void testGetEnclosureById(){
		Integer enclosureId = 1;
		target.getAnimalEnclosureById(enclosureId);
		verify(mockEnclosureDao, times(1)).getEnclosureById(enclosureId);
	}
	

}
