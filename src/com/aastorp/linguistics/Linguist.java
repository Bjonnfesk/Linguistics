/*
 * 
 */
package com.aastorp.linguistics;

/**
 * A Linguist is a class that performs linguistic operations on text.
 * 
 * @author Bjørn Aastorp
 */
public abstract class Linguist {

	/**
	 * Instantiates a new linguist.
	 */
	public Linguist() {
		super();
	}
	
	/**
	 * Do the work that this Linguist is an expert at, determined 
	 * by its class which is a subclass of Linguist. A Padder pads
	 * a String, an Inflector pluralises a unit according to a value...
	 * 
	 * @return The result of the Linguist's work.
	 */
	public abstract Object work();

}