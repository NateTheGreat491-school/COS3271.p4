/*
* Copyright (c) 2026 Nathan William Barros. All rights reserved.
*
* Licensed under the MIT License (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    https://opensource.org/licenses/MIT
*    OR
*    see repo LICENSE
*/

/**
* Assignment 4a: Person Class with Interactions
*
* @author Nathan W. Barros (nwbarros@students.unwsp.edu)
* @course COS 3271
* @version 1.0.0
*/

package COS3271.p4;

public class Person {
	public static final int      MAX_AGE    = 125;    // historical record: 122 yr
	public static final double   MAX_WEIGHT = 700.0;  // historical record: 668 kg
	public static final double   MAX_HEIGHT = 300.0;  // historical record: 272 cm
	public static final String[] GENDERS    = {"male", "female"};

	private String  firstName;
	private String  lastName;
	private String  gender;
	private String  religion;
	private Integer age;
	private Double  weight;
	private Double  height;

	/** Factory method that gathers all attributes from the user.
	*
	* @param escapeStr - If user input = escapeStr, return null
	* @return Person() || null
	* */
	public static Person createByUser(String escapeStr) {
		System.out.println("Please create your person...");

		Person p = new Person();

		p.firstName = Utility.queryUser("First Name: ", null, escapeStr);
		if (p.firstName == null) return null;

		p.lastName = Utility.queryUser("Last Name: ", null, escapeStr);
		if (p.lastName == null) return null;

		p.gender = Utility.queryUser("Gender: ", GENDERS, escapeStr);
		if (p.gender == null) return null;

		p.age = Utility.getIntFromRange("Age (yr): ", 0, MAX_AGE, escapeStr);
		if (p.age == null) return null;

		p.weight = Utility.getDoubleFromRange("Weight (kg): ", 0.0, MAX_WEIGHT, escapeStr);
		if (p.weight == null) return null;

		p.height = Utility.getDoubleFromRange("Height (cm): ", 0.0, MAX_HEIGHT, escapeStr);
		if (p.height == null) return null;

		p.religion = Utility.queryUser("Religion: ", null, escapeStr);
		if (p.religion == null) return null;

		return p;
	}

	/** Prints a simple formatted table (with optional header). */
	public static void showBioTable(Person p, boolean showHeader) {
		String seperator = "+----------------------+--------+-----+----------+----------+----------------------+\n";

		if (showHeader) {
		System.out.printf(
			  "| %-20s | %-6s | %-3s | %-8s | %-8s | %-20s |%n" + seperator,
			  "Full Name", "Gender", "Age", "Weight", "Height", "Religion");
		}

		System.out.printf("| %-20s | %-6s | %-3d | %-8.2f | %-8.2f | %-20s |%n" + seperator,
					p.firstName + " " + p.lastName,
					p.gender, p.age, p.weight, p.height, p.religion);
	}
}
