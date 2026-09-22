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

	Person(String firstName, String lastName, String gender, 
		   String religion, Integer age, Double weight, Double height) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.gender    = gender;
		this.religion  = religion;
		this.age       = age;
		this.weight    = weight;
		this.height    = height;
	}

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

	public String greet() {
		return "Hello, my name is "+ this.getName() +". Nice to meet you!";
	}

	public static String pray() {
		String prayer;

		switch (this.religion.toLowerCase()) {
			case "christianity", "christian" -> prayer = 
					"A Christian's request:\n"+
					"    Come, Holy Spirit, fill the hearts of your faithful and kindle in them\n"+
					"    the fire of your love. Send forth your Spirit and they shall be created\n"+
					"    and you will renew the face of the earth. Lord, by the light of the\n"+
					"    Holy Spirit you have taught the hearts of your faithful. In the same Spirit\n"+
					"    help us to relish what is right and always rejoice in your consolation.\n"+
					"    We ask this through Christ our Lord. Amen.";

			case "islam", "muslim" -> prayer = 
					"A Muslim's Prayer:\n"+
					"    Get rid of the hardship and heal, O Lord of the People,\n"+
					"    you are the Healer, and there is no healing of disease like\n"+
					"    Yours. Let it be healing that is not betrayed by sickness.";
			
			case "buddhism", "buddhist" -> prayer = 
					"A Buddhist's Blessing:\n"+
					"    May all beings have happiness and the causes of happines;\n"+
					"    May all be free from sorrow and the causes of sorrow;\n"+
					"    May all never be seperated from the sacred happiness which is sorrowless;\n"+
					"    And may all live in equanimity, without too much attatchment and too much aversion,\n"+
					"    and live believing in the equality of all that lives.";

			case "hinduism", "hindu" -> prayer = 
					"A Hindu's Song: A Prayer of Good Over Evil, Light Over Dark.\n"
					"    Fill the Heart with the oil of love.\n"+
					"    Place in it the wick of single-pointed mind.\n"+
					"    Light it with the Knowledge of Truth and remove\n"+
					"    the darkness of ignorance around you.\n"+
					"    Just as one lamp can light many lamps; let each\n"+
					"    youth kindle this Light in many hearts.";

			case "atheism", "atheist" -> prayer =
					"An Atheists Confession:\n"+
					"    God, I don't believe in You. As far as I know,\n"+
					"    you don't exist. But I do feel something.\n"+
					"    So if I'm making a big mistake, I want You to know,\n"+
					"    God, I have no quarrel against You.  It's just that\n"+
					"    I don't know that you exist. But God, just in case\n"+
					"    You're really there and I'm making a mistake,\n"+
					"    Get me an introduction.";

			default -> prayer =
				"A Prayer for Peace:"+
				"    In moments of turmoil, may I find a quiet place within myself.\n"+
				"    Let my mind be still and my heart be at peace, no matter\n"+
				"    the external circumstances. In the stillnes, may I find the\n"+
				"    strength to face my challenges. Let the calm within me be a\n"+
				"    source of power and resilience for myself and others around me.";
		}

		return prayer;
	}
	
	/*
	 * Waits for user input to simulate sleeping
	 */ 
	public static void goToSleep() {
		System.out.print("Goodnight... zzz\n[wake up]");
		new Scanner(System.in).nextLine();
	}

	public static String eat(String food) {
		return "I have eaten a/an "+ food +"!";
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public void changeReligion(String newFaith) {
		this.religion = newFaith;
	}
}
