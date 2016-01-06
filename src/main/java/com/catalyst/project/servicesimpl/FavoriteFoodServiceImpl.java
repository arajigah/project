package com.catalyst.project.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.project.daos.FavoriteFoodDao;
import com.catalyst.project.entities.FavoriteFood;
import com.catalyst.project.services.FavoriteFoodService;

@Service
public class FavoriteFoodServiceImpl implements FavoriteFoodService{

	@Autowired
	FavoriteFoodDao favoriteFoodDao;

	@Override
	public List<FavoriteFood> getAllFoods() {
		return favoriteFoodDao.getAllFoods();
	}
}
