package com.catalyst.project.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.project.daos.AnimalEnclosureDao;
import com.catalyst.project.entities.AnimalEnclosure;

/**
 * Animal Enclosure DAO class, Handles all interactions with with AnimalEnclosure Table in the Database.
 * 
 * @author cmiller
 */
@Repository
@Transactional
public class AnimalEnclosureDaoImpl implements AnimalEnclosureDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * Gets a list of all the Animal Enclosures from the Database
	 * 
	 * @return List <AnimalEnclosure>
	 * @author cmiller
	 */
	@Override
	public List<AnimalEnclosure> getAllAnimalEnclosures() {
		return em.createQuery("SELECT a FROM AnimalEnclosure a", AnimalEnclosure.class).getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	/** 
	 * Adds the Animal Enclosure to the Database
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	

	/**
	 * Updates and existing AnimalEnclosure in the Database
	 * 
	 * @param AnimalEnclosure
	 * @author cmiller
	 */
	@Override
	public void updateAnimalEncolsure(AnimalEnclosure animalEnclosure) {
		em.merge(animalEnclosure);	
	}

	/**
	 * Gets a Enclosure by id then removes it from the Database
	 * 
	 * @param Integer animaleEnclosureId
	 * @author cmiller
	 */
	@Override
	public void deleteAnimalEnclosure(Integer enclosureId) {
		AnimalEnclosure animalEnclosure = getEnclosureById(enclosureId);
		em.remove(animalEnclosure);
		
	}
	
	/**
	 * Gets an Animal Enclosre by its id from the Database
	 * 
	 * @param Integer animalEnclosureId
	 * @return AnimalEnclosure
	 * @author cmiller
	 */
	@Override
	public AnimalEnclosure getEnclosureById(Integer enclosureId){
		return em.createQuery("SELECT a FROM AnimalEnclosure a WHERE a.animalEnclosureId = :enclosureId", AnimalEnclosure.class)
				.setParameter("enclosureId", enclosureId)
				.getSingleResult();
	}


	
	@Override
	public void addAnimalEncolsure(AnimalEnclosure animalEnclosure) {
		em.merge(animalEnclosure);
		
	}
}
