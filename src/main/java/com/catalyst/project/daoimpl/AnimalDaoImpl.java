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
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
