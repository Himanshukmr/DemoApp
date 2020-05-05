package com.zoo.util;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zoo.model.Animal;
import com.zoo.model.Bird;
import com.zoo.model.Mammal;
import com.zoo.model.Reptile;

@Component
public class AnimalUtil {

	public List<String> getAnimalSpecie(String typeId) {

		Map<String, List<String>> specieRecord = getSpeciData();

		return specieRecord.get(typeId.toUpperCase());

	}

	public Map<String, List<String>> getSpeciData() {
		Map<String, List<String>> specieRecord = new HashMap<>();
		List<String> birdSpecie = new ArrayList<>();
		birdSpecie.add("Ostriches");
		birdSpecie.add("Eagles");
		birdSpecie.add("Ducks");
		birdSpecie.add("Emu");
		birdSpecie.add("Geese");

		List<String> mammalSpecie = new ArrayList<>();
		mammalSpecie.add("Lion");
		mammalSpecie.add("Tigers");
		mammalSpecie.add("Cheeta");
		mammalSpecie.add("Polar bear");
		mammalSpecie.add("Brown bear");
		mammalSpecie.add("Black bear");
		mammalSpecie.add("Coyotes");
		mammalSpecie.add("Wolves");
		mammalSpecie.add("Monkey");

		List<String> reptileSpecie = new ArrayList<>();
		reptileSpecie.add("Snakes");
		reptileSpecie.add("Alligators");
		reptileSpecie.add("Turtle");
		reptileSpecie.add("Viper");

		specieRecord.put("BIRD", birdSpecie);
		specieRecord.put("MAMMAL", mammalSpecie);
		specieRecord.put("REPTILE", reptileSpecie);

		return specieRecord;

	}
	
	public static Animal getAnimalSpecificProperties(String type) {
		
		if(type.equalsIgnoreCase("bird")) {
			return new Bird();
		}else if(type.equalsIgnoreCase("Reptile")){
			return new Reptile();
		}else if(type.equalsIgnoreCase("Mammal")) {
			return new Mammal();
		}
		
		return null;
		
	}
}