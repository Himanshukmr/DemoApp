package com.zoo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "animal")
public class AnimalPropertie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private final int exhibitionNumb;
	
	
	@NotEmpty(message = "Please provide a specie")
	private String specie;
	
	@NotEmpty(message = "Please provide a name")
	private String name;
	
	@NotEmpty(message = "Please provide a gender")
	private String gender;
	
	@NotEmpty(message = "Please provide a type")
	private String type;
	
	private String animalSound;
	
	private String animalMove;

	public AnimalPropertie() {
		exhibitionNumb = id;
//		id++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExhibitionNumb() {
		return exhibitionNumb;
		
	}
	
	public String getAnimalSound() {
		return animalSound;
	}

	public void setAnimalSound(String animalSound) {
		this.animalSound = animalSound;
	}

	public String getAnimalMove() {
		return animalMove;
	}

	public void setAnimalMove(String animalMove) {
		this.animalMove = animalMove;
	}
	

	@Override
	public String toString() {
		return "AnimalPropertie [exhibitionNumb=" + exhibitionNumb + ", specie=" + specie + ", name=" + name + ", gender="
				+ gender + ", type=" + type + "]";
	}
	
	@Override 
	public boolean equals(Object o) {
		  
		  if (o == this) { return true; }
		  
		  if (!(o instanceof AnimalPropertie)) { return false; }
		  
		  AnimalPropertie a = (AnimalPropertie) o;
		  
		  if (a.getName().equalsIgnoreCase(this.getName()) &&
		  a.getType().equalsIgnoreCase(this.getType()) &&
		  a.getSpecie().equalsIgnoreCase(this.getSpecie()) &&
		  a.getGender().equalsIgnoreCase(this.getGender())) { return true; }
		  
		  return false;
		  }

	
	
	

	
}

