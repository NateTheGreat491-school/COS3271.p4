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
 * Assignment 4a: Standalone Person Info App
 *
 * @author Nathan W. Barros (nwbarros@students.unwsp.edu)
 * @course COS 3271
 * @version 1.1.0
 */
package COS3271.p4;

import java.util.Scanner;

public class LifeSimulator {

	private static Scanner userin = new Scanner(System.in);

	/*
	 * Prompts user to create a person then displays their bio
	 */
    public static void main(String[] args) {
		String response;
		Person p1 = Person("John", "Doe", "male", "christian", 37, 78.5, 178.5);

		while (true) {
			showHome();

			response = userin.nextLine();
			System.out.print("\n\n");

			switch (response.toLowerCase()) {

				case "v","1" -> Person.showBioTable(p1, true);
				case "c","2" -> p1 = Person.createByUser();
				case "g","3" -> p1.greet();
				case "p","4" -> p1.pray();
				case "f","5" -> p1.eat( getFood() );
				case "s","6" -> p1.goToSleep();
				case "e","7" -> p1.changeReligion( getReligion() );
				default -> 
					System.out.print("----- invalid selection -----\n[continue]");
					userin.nextLine();
			}
		}

		Utility.handleExit("Goodbye.", 0);
    }

	private static String getFood() {
		System.out.print("Enter any food: ");
		return userin.nextLine();
	}

	private static String getReligion() {
		System.out.print("Enter any religion: ");
		return userin.nextLine();
	}

	private static showHome() {
		Utility.showBanner("q=quit");
		System.out.print(
				"Options:\n"+
				"    1. [V]iew Person"
				"    2. [C]reate new Person\n"+
				"    3. [G]reet\n"+
				"    4. [P]ray\n"+
				"    5. [F]eed\n"+
				"    6. [S]leep\n+
				"    7. [E]dit Religion\n\n"+

				" : ");
	}
}

// EOF
