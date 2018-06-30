package com.aastorp.linguistics;

import java.util.Map;
import java.util.HashMap;


public class LinguistTest {
	
	private static HashMap<String, Object> animals = new HashMap<String, Object>();
	
	public static void main(String[] args) {
		
		double cats = 1.2;
		int dogs = 3;
		Integer sheep = 0;
		Double flies = 1.0;
		double birds = 15.3;
		long wasps = 1;
		
		animals.put("cat", cats);
		animals.put("dog", dogs);
		animals.put("sheep", sheep);
		animals.put("fly", flies);
		animals.put("bird", birds);
		animals.put("wasp", wasps);
		animals.put("lioness", 1);
		printAnimals();
		
		System.out.println("The lioness swatted the annoying wasp :D");
		animals.put("wasp", 0);
		animals.put("dead wasp", 1);
		animals.put("lioness", 0);
		animals.put("wasp-stung lioness", 1);
		
		printAnimals();
		
		animals.put("fly", flies + 11);
		
		System.out.println("SOME FLIES ARRIVED!");
		
		printAnimals();
		
		animals.put("sheep", sheep + 1);
		animals.put("lioness", (int)animals.get("lioness") + 2);
		
		System.out.println("Now there's a sheep! Its friends the lionesses also approach!");
		
		printAnimals();
		
		System.out.println("The cute .2 kitten grew into a cat!");
		
		animals.put("cat", (double)animals.get("cat") + .8);
		
		printAnimals();
		
		System.out.println("leftPadding test with Padder...");
		Padder padder = new Padder("test", "left", 8);
		System.out.println(padder.work());
		
		System.out.println("\r\nUsing Padder to generate a header...\r\n");
		String headerText = "Lorem Ipsum Dolor Sit Amet";
		padder = new Padder("", "centre", headerText.length() + 12, "-");
		System.out.println(padder.work());
		padder.setUnmodifiedString(headerText);
		padder.setPadCharacter("|-- # ");
		padder.setWidth(padder.getUnmodifiedString().length() + padder.getPadCharacter().length());
		padder.setPadSide("left");
		String tmpHeader = (String)padder.work();
		padder.setUnmodifiedString(tmpHeader);
		padder.setPadCharacter(" # --|");
		padder.setWidth(padder.getUnmodifiedString().length() + padder.getPadCharacter().length());
		padder.setPadSide("right");
		tmpHeader = (String)padder.work();
		System.out.println(tmpHeader);
		padder = new Padder("", "centre", headerText.length() + (padder.getPadCharacter().length() * 2), "-");
		System.out.println(padder.work());
		
		System.out.println("\r\nWrapping a 40-character String of asterisks to 10 characters using Wrapper...\r\n");
		String wrapText = (String)new Padder("", "centre", 40, "*").work();
		String wrappedText = (String)new Wrapper(wrapText, 10).work();
		System.out.println(wrappedText);
		System.out.println("\r\nWrapping the same String to 20 characters...\r\n");
		wrappedText = (String)new Wrapper(wrapText, 20).work();
		System.out.println(wrappedText);
	}

	public static void printAnimals() {
		Linguist inflector;
		for (Map.Entry<String, Object> animal : animals.entrySet()) {
			inflector = new Inflector(animal.getKey(), animal.getValue());
			System.out.println("We have " + animal.getValue() + " " + inflector.work());
		}
		System.out.println("\r\n");
	}
}

