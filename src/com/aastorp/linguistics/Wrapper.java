/**
 * 
 */
package com.aastorp.linguistics;

/**
 * Wraps a String to fit within given width (in characters).
 * @author Bjørn Aastorp
 *
 */
public class Wrapper extends WidthTextFormatter {
	
	/** The character(s) used for wrapping. Defaults to system line endings. */
	private String wrapChar;

	/**
	 * Instantiates a new Wrapper.
	 * 
	 * @param stringToWrap The String to wrap.
	 * @param width The desired width of the string after wrapping.
	 */
	public Wrapper(String stringToWrap, int width) {
		super(stringToWrap, width);
		this.setWrapChar(System.getProperty("line.separator"));
	}
	
	/**
	 * Instantiates a new Wrapper.
	 * 
	 * @param stringToWrap The String to wrap.
	 * @param width The desired width of the string after wrapping.
	 * @param wrapChar The character(s) to use for wrapping Strings.
	 */
	public Wrapper(String stringToWrap, int width, String wrapChar) {
		super(stringToWrap, width);
		this.setWrapChar(wrapChar);
	}

	/* (non-Javadoc)
	 * 
	 * @see com.aastorp.linguistics.Linguist#work()
	 */
	@Override
	public Object work() {
		return wrap(this.getUnmodifiedString());
	}

	private String wrap(String text) {
		StringBuilder sb = new StringBuilder();
		if (text.length() > this.getWidth()) {
			sb.append(text.substring(0, this.getWidth()));
			sb.append(this.getWrapChar());
			sb.append(wrap(text.substring(this.getWidth())));
		} else {
			sb.append(text);
		}
		return sb.toString();
	}

	/**
	 * @return The character(s) used for wrapping Strings.
	 */
	public String getWrapChar() {
		return wrapChar;
	}

	/**
	 * @param wrapChar The new character(s) to use for wrapping Strings.
	 */
	public void setWrapChar(String wrapChar) {
		this.wrapChar = wrapChar;
	}

}
