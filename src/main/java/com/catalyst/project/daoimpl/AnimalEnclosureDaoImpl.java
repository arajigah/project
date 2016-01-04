package com.catalyst.project.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;

@Repository
@Transactional
public class AnimalEnclosureDaoImpl implements AnimalEnclosureDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<AnimalEnclosure> getAllAnimalEnclosures() {
		return em.createQuery("SELECT a FROM AnimalEnclosure a", AnimalEnclosure.class).getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void addAnimalEncolsure(AnimalEnclosure animalEnclosure) {
		em.merge(animalEnclosure);
		
	}

	@Override
	public void updateAnimalEncolsure(AnimalEnclosure animalEnclosure) {
		em.merge(animalEnclosure);	
	}

	@Override
	public void deleteAnimalEnclosure(Integer enclosureId) {
		AnimalEnclosure animalEnclosure = getEnclosureById(enclosureId);
		em.remove(animalEnclosure);
		
	}
	
	public AnimalEnclosure getEnclosureById(int enclosureId){
		return em.createQuery("SELECT a FROM AnimalEnclosure a WHERE a.animalEnclosureId = enclosureId", AnimalEnclosure.class)
				.setParameter("enclosureId", enclosureId)
				.getSingleResult();
	}

	
	
}
