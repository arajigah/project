package com.catalyst.project.entities;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="animal_enclosure")
public class AnimalEnclosure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="animal_enclosure_id")
	private int animalEnclosureId;
	
	@NotNull
	@Column(name="animal_enclosure_name")
	private String animalEnclosureName;
	
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;
	 
	@NotNull
	@Column(name="number_of_animals")
	private int numberOfAnimals;
	
	@NotNull
	@Column(name="feeding_time", columnDefinition = "TIME")
	@JsonFormat(pattern="h:mm a", timezone="PST")
	private Date feedingTime;
	 
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="enclosure_condition_id")
	private EnclosureCondition enclosureCondition;

	public int getAnimalEnclosureId() {
		return animalEnclosureId;
	}

	public void setAnimalEnclosureId(int animalEnclosureId) {
		this.animalEnclosureId = animalEnclosureId;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public void setNumberOfAnimals(int numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}

	public EnclosureCondition getEnclosureCondition() {
		return enclosureCondition;
	}

	public Date getFeedingTime() {
		return feedingTime;
	}

	public void setFeedingTime(Date feedingTime) {
		this.feedingTime = feedingTime;
	}

	public void setEnclosureCondition(EnclosureCondition enclosureCondition) {
		this.enclosureCondition = enclosureCondition;
	}

	public String getAnimalEnclosureName() {
		return animalEnclosureName;
	}

	public void setAnimalEnclosureName(String animalEnclosureName) {
		this.animalEnclosureName = animalEnclosureName;
	}
	
}