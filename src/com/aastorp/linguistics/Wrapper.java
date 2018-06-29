/**
 * 
 */
package com.aastorp.linguistics;

/**
 * Wraps strings to fit within given width (in characters).
 * @author Bjørn Aastorp
 *
 */
public class Wrapper extends TextFormatter {
	
	/**  The maximum width of the resulting String. */
	private int maxWidth;
	
	/**
	 * 
	 */
	public Wrapper(String stringToWrap, int maxWidth) {
		final String F = "__constructor";
		
	}

	/* (non-Javadoc)
	 * @see com.aastorp.linguistics.Linguist#work()
	 */
	@Override
	public Object work() {
		// TODO Auto-generated method stub
		final String F = "work";
		return null;
	}

	/**
	 * @return The maximum width of the resulting String of the Wrapper.
	 */
	public int getMaxWidth() {
		final String F = "getMaxWidth";
		return maxWidth;
	}

	/**
	 * @param maxWidth The new maximum width of the resulting String.
	 */
	public void setMaxWidth(int mw) {
		final String F = "setMaxWidth";
		this.maxWidth = mw;
	}

}
