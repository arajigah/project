package com.catalyst.project.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.project.daos.AnimalDao;
import com.catalyst.project.entities.Animal;

@Repository
@Transactional
public class AnimalDaoImpl implements AnimalDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Animal> getAllAnimals() {
		return em.createQuery("SELECT a from Animal a", Animal.class).getResultList();
	}
	
	@Override
	public Animal getAnimalById(Integer animalId) {
		return em.createQuery("SELECT a from Animal a WHERE a.animalId = :animalId", Animal.class)
				.setParameter("animalId", animalId)
				.getSingleResult();
	}

	@Override
	public void addAnimal(Animal animal) {
		em.merge(animal);
		
	}

	@Override
	public void updateAnimal(Animal animal) {
		em.merge(animal);
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
