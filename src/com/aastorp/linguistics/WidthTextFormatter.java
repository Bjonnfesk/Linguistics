package com.aastorp.linguistics;

public abstract class WidthTextFormatter extends TextFormatter {

	/**  The width of the resulting String. */
	private int width;

	public WidthTextFormatter(String unmodifiedString, int width) {
		super(unmodifiedString);
		this.setWidth(width);
	}

	/**
	 * Gets the resulting width of the string, after formatting.
	 *
	 * @return The width of the resulting String of the WidthTextFormatter.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the desired resulting width of the string, after formatting.
	 *
	 * @param mw The new width of the resulting String.
	 */
	public void setWidth(int mw) {
		this.width = mw;
	}

}