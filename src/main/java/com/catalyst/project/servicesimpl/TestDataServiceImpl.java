package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.TestDataDao;
import com.catalyst.project.entities.TestData;
import com.catalyst.project.services.TestDataService;

@Service
public class TestDataServiceImpl implements TestDataService {

	@Autowired
	TestDataDao testDataDao;
	
	
	public void setTestDataDao(TestDataDao testDataDao) {
		this.testDataDao = testDataDao;
	}


	@Override
	public List<TestData> getTestData() {
		return testDataDao.getTestData();
	}

}
