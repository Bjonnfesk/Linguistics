package com.aastorp.linguistics;

// TODO: Auto-generated Javadoc
/**
 * The Class TextFormatter.
 */
public abstract class TextFormatter extends Linguist {

	/**  The unmodified String. */
	protected String us;

	/**
	 * Instantiates a new text formatter.
	 */
	public TextFormatter() {
		super();
	}
	
	/**
	 * Gets the unmodifiedString
	 *
	 * @return The unmodified String of the TextFormatter.
	 */
	public String getUnmodifiedString() {
		final String F = "getUnmodifiedString";
		return us;
	}

	/**
	 * Sets the us.
	 *
	 * @param us The new unmodified String.
	 */
	public void setUnmodifiedString(String us) {
		final String F = "setUnmodifiedString";
		this.us = us;
	}

}