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

	/*
	 * Prompts user to create a person then displays their bio
	 */
    public static void main(String[] args) {
        Utility.showBanner("q=quit");

        Person p1 = Person.createByUser(ESCAPE);
		System.out.print("\n\n");
        if (p1 == null) {
            Utility.handleExit("Goodbye.", 0);
        }
        Person.showBioTable(p1, true);
		System.out.print("\n\n[quit]");
		String waitForUser = new Scanner(System.in).nextLine();

        Utility.handleExit("Goodbye.", 0);
    }
}

// EOF
