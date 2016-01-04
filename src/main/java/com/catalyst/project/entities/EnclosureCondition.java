package com.catalyst.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "enclosure_condition")
public class EnclosureCondition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="enclosure_condition_id")
	private int enclosureConditionId;
	
	@Column(name="enclosure_condition")
	private String enclosureCondition;

	public int getEnclosureConditionId() {
		return enclosureConditionId;
	}

	public void setEnclosureConditionId(int enclosureConditionId) {
		this.enclosureConditionId = enclosureConditionId;
	}

	public String getEnclosureCondition() {
		return enclosureCondition;
	}

	public void setEnclosureCondition(String enclosureCondition) {
		this.enclosureCondition = enclosureCondition;
	}

	
}
