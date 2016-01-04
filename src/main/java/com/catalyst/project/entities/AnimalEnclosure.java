package com.catalyst.project.entities;

import java.io.IOException;
import java.time.LocalTime;
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

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

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
	
	//@NotNull
	//@JsonSerialize(using = DateTimeSerializer.class)
	//@JsonSerialize(using = LocalTimeSerializer.class)
	//@JsonDeserialize(using = LocalTimeDeserializer.class)
	@Column(name="feeding_time")
	@JsonFormat(pattern="h:mm")
	private Date feedingTime;
	//private LocalTime feedingTime;
	 
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

	/*public LocalTime getFeedingTime() {
		return feedingTime;
	}

	public void setFeedingTime(int hour) {
		LocalTime feedingTime = LocalTime.of(hour,0);
		this.feedingTime = feedingTime;
	}*/
	

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
	
	
	/*public class LocalTimeSerializer extends JsonSerializer<LocalTime> {
	    @Override
	    public void serialize(LocalTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
	        arg1.writeString(arg0.toString());
	    }
	}

	public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
	    @Override
	    public LocalTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
	        return LocalTime.parse(arg0.getText());
	    }
	}*/
	
}