package com.zoo.validation;


public class AnimalValidation {
	
	//validate specie/name/type
	 public static boolean checkString( String name ) {
		 String regexUserName = "^[A-Za-z\\s]+$";
	      return name.matches(regexUserName);
	   }
	 
	   // validate gender
	 
	 public static boolean checkGender(String gender) {
       if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
    	   return true;
       }
       return false;
	 }

	 
	 public static boolean checkNumber(String number) {
		 if (!number.matches("[0-9]+")) {
			   return false;
			}
		 return true;
	 }

}


