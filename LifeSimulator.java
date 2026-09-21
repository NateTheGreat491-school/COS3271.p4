/*
 * Copyright (c) 2026 Nathan William Barros. All rights reserved.
 *
 * Licensed under the MIT Licesnse (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License at
 *
 *    https://opensource.org/licenses/MIT
 *    OR
 *    see repo LICENSE
 */

/**
 * Assignment 4a: Person Info App
 *
 * @author Nathan W. Barros (nwbarros@students.unwsp.edu)
 * @course COS 3271
 * @version 1.0.0
 */

package COS3271.p4;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class LifeSimulator {

	/* 
	 * Creates a Person then displays their bio 
	 */
	public static void main(String[] args) {

		Person p1 = Person();
		p1.createByUser();
		p1.showBioTable(p1, true);

	}	

}

private class Person {
	public static int    MAX_AGE    = 125; // oldest person in history was 122 yr
	public static double MAX_WEIGHT = 700; // heaviest person in history was 668 kg
	public static double MAX_HEIGHT = 300; // tallest person in history was 272 cm

	private final String this.gender;
	private String this.firstName;
	private String this.lastName;
	private String this.religion;
	private double this.weight;
	private double this.height;
	private int this.age;
	
	public Person();
	public Person(
			String firsName, String lastName, String gender,
			String religion, double weight, double height, int age) {

				gender = gender.toLower();
				if (weight < 0 || weight > Person.MAX_WEIGHT) {
					throw new IllegalArgumentException(
							"Weight must be between 0 and "+ Person.MAX_WEIGHT + " kg");
				} else if (height < 0 || height > Person.MAX_HEIGHT) {
					throw new IllegalArgumentException(
							"Height must be between 0 and "+ Person.MAX_HEIGHT +" cm");
				} else if !(gender.equals("male") || gender.equals("female")) {
					throw new IllegalArgumentException(
							"Gender must be male or female");
				}

				this.firstName = firstName;
				this.lastName  = lastName;
				this.religion  = religion;
				this.gender = gender;
				this.weight = weight;
				this.height = height;
			}
	
	/*
	 * Prompts the user to enter attributes for a person.
	 *
	 * @return Person obj with filled attributes
	 */ 
	public static Person createByUser() {
		
		Person p = Person();
	
		System.out.print("Please create your person...\n");
		
		Utility.queryUser("First Name: ", null)
		p.firstName = userin.nextLine();
		
		Utility.queryUser("Last Name: ", null);
		p.lastName  = userin.nextLine();

		Utility.queryUser("Gender", {"male", "female"});
		p.gender    = userin.nextLine();

		Utility.queryUser("Religion: ", null);
		p.religion  = userin.nextLine();

		Utility.getDoubleFromRange("Weight (kg): ", 0, Person.MAX_WEIGHT);
		p.weight    = userin.nextDouble();

		Utility.getDoubleFromRange("Height (cm): ", 0, Person.MAX_HEIGHT);
		p.height    = userin.nextDouble();

		Utility.getIntFromRange("Age (yr): ", 0, Person.MAX_AGE); 
		p.age       = userin.nextInt();

		return p;
	}

	/*
	 * Displays Person.attribs as a table row with or without a header.
	 *
	 * @param p          - Person obj
	 * @param showHeader - include header to table (T/F)
	 */
	public static void showBioTable(Person p, boolean showHeader) {
		
		String header = "";

		if (showHeader) {
			header += "| %-41s | %-6s | %-3s | %-6s | %-6s | %-20s |\n".formatted(
						"Full Name", "Gender", "Age", "Weight", "Height", "Religion");
			header += "\n----------------------------------------------------------------------\n"; 
		}

		System.out.printf(
				header +
				"| %-20s %-20s | %-6s | %-3d | %-6.2f | %-6.2f | %-20s |\n"+
				"----------------------------------------------------------------------\n", 
				p.firstName, p.lastName, p.gender,
				p.age, p.weight, p.height, p.religion);


	}
	
}

private class Utiliy {
	static Scanner userin = new Scanner(System.in);

	/*
	 * Query the user for given prompt for 3 attempts then return or exit(0);
	 *
	 * @param prompt - str printed to Sys.out to ask the user for input
	 * @param tests  - str[] of strings to test response equality with. 
	 *				   if "test[0]" equals "response" then is valid response.
	 * @return String response to given prompt / aligned with tests
	 */
	public static String queryUser(String prompt, String[] tests) {
		String response;
		
		for (int attempts=3; attempts > 0; attempts--) {
			System.out.print(prompt);
			String response = userin.nextLine();

			if ( testResponse(response, tests) ) {
				System.out.println();
				return response;
			}

			System.out.print("----- response not in " + Arrays.toString(tests) + " -----\n");
		}

		handleExit("Exceeded allocated attempts."); 
		}
	}
	

	/* 
	 * Gives user 3 attempts to select an int for a range
	 *
	 * @param prompt - str printed to Sys.out to ask user for int
	 */ 
	public static int getIntFromRange(String prompt, int min, int max) {
		
		for (int attempts=3; attempts > 0; attempts--) {
			System.out.print(prompt);

			try {
				int response = userin.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("----- invalid int -----\n");
				continue;
			}

			if (response < min || response > max) {
				System.out.printf("----- Range %d to %d -----", min, max);
				continue;
			}
			return response;
		}

		handleExit("Exceeded allocated attempts.");
	}

	/*
	 * Gives user 3 attempts to select a double for a range.
	 *
	 * @param prompt - str printed to Sys.out to ask user for int
	 */ 
	public static double getDoubleFromRange(String prompt, double min, double max) {
		
		for (int attempts=3; attempts > 0; attempts--) {
			System.out.print(prompt);

			try {
				double response = uersin.nextDouble();
			} catch (InputMismatchException e) {
				System.out.print("----- invalid doube -----\n");
				continue;
			}

			if (response < min || response > max) {
				System.out.print("----- range %f to %f -----", min, max);
				continue;
			}
			return response;
		}

		handleExit("Exceeded allocated attempts.");
	}
	
	public static boolean testResponse(String response, String[] tests) {
		if (tests = null) return true;

		for (int i=0; i<tests.length; i++) {
			if (test[i].equals( response.toLower() )) return true;
		}
		return false;
	}
}

// EOF
