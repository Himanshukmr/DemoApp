package com.zoo.model;

public enum AnimalTypeEnum {

	BIRD("Bird"), MAMMAL("Mammal"), REPTILE("Reptile");
	

	private final String name;

	AnimalTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
