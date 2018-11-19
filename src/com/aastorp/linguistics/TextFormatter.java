package com.aastorp.linguistics;

// 
/**
 * Base class for TextFormatters such as Wrappers.
 */
public abstract class TextFormatter extends Linguist {

	/**  The unmodified String. */
	protected String us;

	/**
	 * Instantiates a new text formatter.
	 * 
	 * @param unmodifiedString The new unmodified String.
	 */
	public TextFormatter(String unmodifiedString) {
		this.setUnmodifiedString(unmodifiedString);
	}
	
	/**
	 * Gets the unmodifiedString
	 *
	 * @return The unmodified String of the TextFormatter.
	 */
	public String getUnmodifiedString() {
		return us;
	}

	/**
	 * Sets the unmodifiedString.
	 *
	 * @param us The new unmodified String.
	 */
	public void setUnmodifiedString(String us) {
		this.us = us;
	}

}