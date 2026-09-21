/* File:	Person Info App
 * Devs:	Nathan W. Barros
 * Origin:	2026-09-21 08:15:32
 * Edited:	2026-09-21 08:15:49
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class LifeSimulator {

public static void main(String[] args) {



}

}

private class Person {
	final String this.gender;
	String this.firstName;
	String this.lastName;
	String this.religion;
	double this.weight;
	double this.height;
	int this.age;

	static Scanner userin = new Scanner(System.in);

	public static Person createByUser() {
		
		Person p = Person();
	
		System.out.print("Please create your person...\n");
		
		queryUser("First Name: ", null)
		p.firstName = userin.nextLine();
		
		queryUser("Last Name: ", null);
		p.lastName  = userin.nextLine();

		queryUser("Gender", {"male", "female"});
		p.gender    = userin.nextLine();

		queryUser("Religion: ", null);
		p.religion  = userin.nextLine();

		getDouble("Weight (kg): ", 0, 700); // heaviest person in history 662 kg
		p.weight    = userin.nextDouble();

		getDouble("Height (cm): ", 0, 300); // tallest person in history 272 cm
		p.height    = userin.nextDouble();

		getInt("Age (yr): ", 0, 125); // older person (nobbiblical) 122 yr 164 d
		p.age       = userin.nextInt();

		return p;
	}
	
}

private class Helper {

	public static String queryUser(String prompt, String[] tests) {
		String response;
		
		for (int attempts=3; attempts > 0; attempts--) {
			System.out.print(prompt);
			String response = userin.nextLine();

			if ( checkResponse(response, tests) ) {
				System.out.println();
				return response;
			}
		}

		handleExit("Exceeded allocated attempts."); 
		}
	}

	public static int getInt(String prompt, int min, int max) {
		
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

	public static double getDouble(String prompt, double min, double max) {
		
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

	public static boolean checkResponse(String response, String[] tests) {
		if (tests = null) return true;

		for (int i=0; i<tests.length; i++) {
			if (test[i].equals( response.toLower() )) return true;
		}
		return false;
	}
}

// EOF
