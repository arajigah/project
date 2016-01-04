package com.catalyst.project.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.project.daos.EnclosureConditionDao;
import com.catalyst.project.entities.EnclosureCondition;

@Repository
@Transactional
public class EnclosureConditionDaoImpl implements EnclosureConditionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<EnclosureCondition> getEnclosureConditions() {
		return em.createQuery("SELECT e FROM EnclosureCondition e", EnclosureCondition.class).getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
