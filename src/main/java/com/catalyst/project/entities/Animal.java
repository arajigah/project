package com.catalyst.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="animal_id")
	private int animalId;
	
	@NotNull
	@Column(name="animal_name")
	private String animalName;
	
	@NotNull
	@Column(name="scientific_name")
	private String scientificName;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="favorite_food_id")
	private FavoriteFood favoriteFood;
	
	@NotNull
	@Column(name="informational_link")
	private String informationalLink;

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public FavoriteFood getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(FavoriteFood favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String getInformationalLink() {
		return informationalLink;
	}

	public void setInformationalLink(String informationalLink) {
		this.informationalLink = informationalLink;
	}
	
	
	
}
