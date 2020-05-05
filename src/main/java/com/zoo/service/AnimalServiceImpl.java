package com.zoo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.model.Animal;
import com.zoo.model.AnimalPropertie;
import com.zoo.model.AnimalTypeEnum;
import com.zoo.repo.AnimalRepository;
import com.zoo.util.AnimalUtil;
import com.zoo.validation.AnimalValidation;

@Service
public class AnimalServiceImpl implements AnimalService {

	static List<AnimalPropertie> animalList = new ArrayList<>();

	@Autowired
	AnimalUtil animalUtil;
	
	@Autowired
	AnimalRepository animalRepository;

	@Override
	public List<String> getAnimalType() {

		AnimalTypeEnum[] types = AnimalTypeEnum.values();
		List<String> annimalType = new ArrayList<>();

		for (AnimalTypeEnum type : types) {
			annimalType.add(type.getName());
		}

		annimalType = annimalType.stream().sorted().collect(Collectors.toList());
		return annimalType;
	}

	@Override
	public List<String> getAnimalSpecie(String typeId) {

		List<String> animalSpecieList = animalUtil.getAnimalSpecie(typeId);
		animalSpecieList = animalSpecieList.stream().sorted().collect(Collectors.toList());
		return animalSpecieList;

	}

	@Override
	public String addAnimal(AnimalPropertie animal) {
		if (animalList != null && animalList.size() > 0 && animalList.contains(animal)) {
			return "present";
		}
		if(!AnimalValidation.checkString(animal.getName()))
			return "Name is not valid";
		
		if(!AnimalValidation.checkString(animal.getSpecie()))
			return "Specie is not valid";
		
		if(!AnimalValidation.checkString(animal.getType()))
			return "Type is not valid";
		
		if(!AnimalValidation.checkGender(animal.getGender())) {
			return "Not a valid gender";
		}
		
		if(!AnimalValidation.checkNumber(animal.getExhibitionNumb()+"")) {
			return "Id should be numeric";
		}
		
		Animal animalObj = AnimalUtil.getAnimalSpecificProperties(animal.getType());
		animal.setAnimalSound(animalObj.makeSound());
		animal.setAnimalMove(animalObj.move());
		
		animalRepository.save(animal);
		// animalList.add(animal);
		return "notPresent";

	}

	@Override
	public List<AnimalPropertie> getAllAnimale() {
		return animalRepository.findAll();
	}

	@Override
	public List<AnimalPropertie> deleteAnimal(int animalId) {
		animalRepository.deleteById(animalId);
		return animalRepository.findAll();

	}

//	List<AnimalPropertie> deleteAnimal(int animalId){
//	}
//}

}
