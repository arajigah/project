package com.catalyst.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.project.entities.Animal;
import com.catalyst.project.entities.FavoriteFood;
import com.catalyst.project.services.FavoriteFoodService;

@RestController
public class FavoriteFoodController {
	
	@Autowired
	FavoriteFoodService favoriteFoodService;
	
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public List<FavoriteFood> getAllFoods(){
		return favoriteFoodService.getAllFoods();
	}
	
}
