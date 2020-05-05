package com.zoo.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.model.AnimalPropertie;
import com.zoo.model.AnimalStatus;
import com.zoo.service.AnimalService;

@RestController
public class AnimalController {

	@Autowired
	AnimalService animalPropertieService;

	@GetMapping("/animal")
	public List<String> getAnimalType() {
		System.out.println(animalPropertieService.getAnimalType());

		return animalPropertieService.getAnimalType();

	}

	@GetMapping("animal/{typeId}")
	public List<String> getAnimalSpecie(@PathVariable String typeId) {
		return animalPropertieService.getAnimalSpecie(typeId);
	}

	@PostMapping("/animal")
	public AnimalStatus addAnimal(@Valid @RequestBody AnimalPropertie animal) {
		String msg = animalPropertieService.addAnimal(animal);
		AnimalStatus status = new AnimalStatus();
		if (msg.equals("notPresent")) {
			status.setStatusCode(200);
			status.setStatusMsg("Record successfully saved");
		} else if (msg.equalsIgnoreCase("Name is not valid")) {
			status.setStatusCode(400);
			status.setStatusMsg("Name is not valid please enter valid name!!");
		} else {
			status.setStatusCode(400);
			status.setStatusMsg("Record already present in table");
		}

		return status;

	}

	@PostMapping("animal/{id}")
	public String addAnyAnimal() {
		return "added";
	}

	@GetMapping("/allAnimal")
	public List<AnimalPropertie> getAllAnimal() {
		return animalPropertieService.getAllAnimale();

	}

	@DeleteMapping("animal/{id}")
	public List<AnimalPropertie> deleteAnimal(@PathVariable int id) {
		return animalPropertieService.deleteAnimal(id);

	}
}