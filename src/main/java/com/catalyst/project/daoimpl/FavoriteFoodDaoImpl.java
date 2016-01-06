package com.catalyst.project.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.project.daos.FavoriteFoodDao;
import com.catalyst.project.entities.FavoriteFood;

@Repository
@Transactional
public class FavoriteFoodDaoImpl implements FavoriteFoodDao{

	@PersistenceContext
	private EntityManager em;

	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<FavoriteFood> getAllFoods() {
		return em.createQuery("SELECT f FROM FavoriteFood f", FavoriteFood.class).getResultList();
	}
}
