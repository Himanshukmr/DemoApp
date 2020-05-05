package com.zoo.model;

public class Reptile implements Animal {

	@Override
	public String makeSound() {
		return "Fu-FU";
		
	}

	
	@Override
	public String move() {
		return "Serpentine";
	}


}
