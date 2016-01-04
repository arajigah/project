package com.catalyst.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_category")
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="food_category_id")
	private int foodCategoryId;
	
	@Column(name = "food_category", unique=true)
	private String foodCategory;

	public int getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(int foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	
}
