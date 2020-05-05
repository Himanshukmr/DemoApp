package com.zoo.model;

public class Bird implements Animal {
	
	@Override
	public String makeSound() {
		  return "Tweet, tweet!";
		
	}

	@Override
	public String move() {
		return "fly";
	}

}
