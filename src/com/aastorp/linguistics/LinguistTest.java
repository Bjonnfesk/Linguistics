package com.aastorp.linguistics;

import java.util.Map;
import java.util.HashMap;


public class LinguistTest {

	public LinguistTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		double cats = 1.2;
		int dogs = 3;
		Integer sheep = 0;
		Double flies = 1.0;
		double birds = 15.3;
		long wasps = 0;
		
		HashMap<String, Object> animals = new HashMap<String, Object>();
		
		animals.put("cat", cats);
		animals.put("dog", dogs);
		animals.put("sheep", sheep);
		animals.put("fly", flies);
		animals.put("bird", birds);
		animals.put("wasp", wasps);
		animals.put("lioness", 1);
		/* make a class "ExclusionList" that has a list of words
		 * that do not follow the usual rule of just adding an
		 * "s" to the end of the word. The list should also
		 * specify the function that should be performed on these
		 * words to pluralise them correctly.
		 */
		printAnimals(animals);
		
		animals.put("fly", flies + 11);
		
		System.out.println("SOME FLIES ARRIVED!");
		
		printAnimals(animals);
		
		animals.put("sheep", sheep + 1);
		animals.put("lioness", (int)animals.get("lioness") + 1);
		
		System.out.println("Now there's a sheep! Its friend the lioness also approaches!");
		
		printAnimals(animals);
		
		Linguist padder = new Padder("test", "center", 8);
		System.out.println(padder.work());
		
		padder = new Padder("", "center", 8, "*");
		System.out.println(padder.work());
	}

	public static void printAnimals(Map<String, Object> animals) {
		Linguist inflector;
		for (Map.Entry<String, Object> animal : animals.entrySet()) {
			inflector = new Inflector(animal.getKey(), animal.getValue());
			System.out.println("We have " + animal.getValue() + " " + inflector.work());
		}
		
	}
}
