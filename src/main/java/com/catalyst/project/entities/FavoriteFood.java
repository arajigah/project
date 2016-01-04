package com.catalyst.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite_food")
public class FavoriteFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favorite_food_id")
	private int favoriteFoodId;
	
	@Column(name="favorite_food_name", unique= true)
	private String favoriteFoodName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="food_category_id")
	private FoodCategory foodCategory;

	public int getFavoriteFoodId() {
		return favoriteFoodId;
	}

	public void setFavoriteFoodId(int favoriteFoodId) {
		this.favoriteFoodId = favoriteFoodId;
	}

	public String getFavoriteFoodName() {
		return favoriteFoodName;
	}

	public void setFavoriteFoodName(String favoriteFoodName) {
		this.favoriteFoodName = favoriteFoodName;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	
}
