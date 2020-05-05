package com.zoo.service;

import java.util.List;

import com.zoo.model.AnimalPropertie;

public interface AnimalService {
	
	List<String> getAnimalType();
	
	List<String> getAnimalSpecie(String typeId);
	
	String addAnimal(AnimalPropertie animal);
	
	List<AnimalPropertie> getAllAnimale();
	
	List<AnimalPropertie> deleteAnimal(int animalId);

	
}
