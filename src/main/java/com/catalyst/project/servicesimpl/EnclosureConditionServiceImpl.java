package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.EnclosureConditionDao;
import com.catalyst.project.entities.EnclosureCondition;
import com.catalyst.project.services.EnclosureConditionService;

@Service
public class EnclosureConditionServiceImpl implements EnclosureConditionService{

	@Autowired
	EnclosureConditionDao enclosureConditionDao;
	
	
	@Override
	public List<EnclosureCondition> getEnclosureConditions() {
		return enclosureConditionDao.getEnclosureConditions();
	}

}
