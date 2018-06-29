/**
 * 
 */
package com.aastorp.linguistics;

import javax.swing.JOptionPane;

/**
 * Pads a String (with spaces) to the specified length, either on 
 * the left side, right side or in the center, trimming the String 
 * if it is too long. If the String ends in "()", Padder assumes 
 * it is a function name, and will retain the suffix even if these 
 * characters would normally be removed due to the String being 
 * too long. This Linguist understands both American and British
 * spelling conventions.
 *
 * @author Bjørn Aastorp
 * 
 */
public class Padder extends TextFormatter {
	
	/**  The side to pad on: 0 = left, 1 = right, 2 = center. */
	private int ps;
	
	/**  The width of the resulting String. */
	private int width;
	
	/** The character to pad with */
	private String pc = " ";
	
	/**
	 * Instantiates a new padder.
	 *	
	 * @param stringToPad The string to pad.
	 * @param padSide The side to pad the string on. Valid values are "left", "right" and "center"/"centre".
	 * @param width The desired width of the string after padding.
	 * 
	 */
	public Padder(String stringToPad, String padSide, int width) {
		final String F = "__constructor";
		this.setPadSide(padSide.toLowerCase());
		this.setWidth(width);
		this.setUnmodifiedString(stringToPad);
	}
	
	/**
	 * Instantiates a new padder.
	 *	
	 * @param stringToPad The string to pad.
	 * @param padSide The side to pad the string on. Valid values are "left", "right" and "center".
	 * @param width The resulting width of the string after it is padded.
	 * @param padCharacter The character to pad the string with.
	 * 
	 */
	public Padder(String stringToPad, String padSide, int width, String padCharacter) {
		final String F = "__constructor";
		this.setPadSide(padSide);
		this.setWidth(width);
		this.setUnmodifiedString(stringToPad);
		this.setPadCharacter(padCharacter);
	}
	
	/* (non-Javadoc)
	 * @see com.aastorp.linguistics.Linguist#work()
	 */
	@Override
	public Object work() {
		final String F = "work";
		switch (this.getPadSide()) {
		//Left, Right & Centre
		case "left":
			return this.leftPad();
		case "right":
			return this.rightPad();
		case "center": 
			return this.centerPad();
		case "centre": 
			return this.centerPad();
		default:
			return "Invalid pad side, valid pad sides are: \"left\", \"right\" and \"center\"/\"centre\"";
		}
	}
	
	/**
	 * Left-pad a String to the specified length. If the String is too long, 
	 * it will be trimmed. If the String ends in "()", leftPad() assumes it 
	 * is a function name, and will retain the suffix even if these characters 
	 * would normally be removed due to the String being too long.
	 *
	 * @return The padded String
	 */
	private String leftPad() {
		final String F = "leftPad";
		/*if (this.getUnmodifiedString().length() > this.getWidth()) {
			if (this.getUnmodifiedString().substring(this.getUnmodifiedString().length() - 2, this.getUnmodifiedString().length()).equals("()")) {
				return String.format("%" + (this.getWidth() - 3) + "." + (this.getWidth() - 3) + "s", this.getUnmodifiedString()) + "…()";
			} else {
				return String.format("%" + (this.getWidth() - 1) + "." + (this.getWidth() - 1) + "s", this.getUnmodifiedString()) + "…";
			} //yeeeeeeeaaaaaaaaaa...... that's unintelligible.
		} else if (this.getUnmodifiedString().length() == 2) {
			return String.format("%" + this.getWidth() + "." + this.getWidth() + "s", "");
		} else {
			return String.format("%" + this.getWidth() + "." + this.getWidth() + "s", this.getUnmodifiedString());
		}*/
		StringBuilder sb = new StringBuilder();
		if (this.getUnmodifiedString().length() == this.getWidth()) {
			//string is ALREADY the right length...
			return this.getUnmodifiedString();
		} else if (this.getUnmodifiedString().length() < this.getWidth()) {
			//string is too short...
			for (int i = this.getUnmodifiedString().length(); i < this.getWidth(); i++) {
				//add the amount of characters required....
				sb.append(this.pc);
			}
			sb.append(this.getUnmodifiedString());
		} else if (this.getUnmodifiedString().length() > this.getWidth()) {
			//string is too long...
			if (this.getUnmodifiedString().substring(this.getUnmodifiedString().length() - 2, this.getUnmodifiedString().length()).equals("()")) {
				//string is a function name...
				sb.append(this.getUnmodifiedString().substring(0, this.getWidth() - 3));
				sb.append("…()");
			} else {
				//string is not a function name...
				sb.append(this.getUnmodifiedString().substring(0, this.getWidth() - 1));
				sb.append("…");
			}
		}
		if (sb.length() != this.getWidth()) {
			JOptionPane.showMessageDialog(null, "Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
		}
		return sb.toString();
		
	}
	
	/**
	 * Center-pad a String to the specified length. If the String is too long, 
	 * it will be trimmed. 
	 *
	 * @return The padded String
	 */
	private String centerPad() {
		final String F = "centerPad";
		if (
			this.getUnmodifiedString() == null || 
			this.getWidth() <= this.getUnmodifiedString().length()
			) 
		{
			return this.getUnmodifiedString();
		}
		StringBuilder sb = new StringBuilder(this.getWidth());
		for (int i = 0; i < (this.getWidth() - this.getUnmodifiedString().length()) / 2; i++) {
			sb.append(this.getPadCharacter());
		}
		sb.append(this.getUnmodifiedString());
		while (sb.length() < this.getWidth()) {
			sb.append(this.getPadCharacter());
		}
		if (sb.length() != this.getWidth()) {
			JOptionPane.showMessageDialog(null, "Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
		}
		return sb.toString();
	}

	/**
	 * Right-pad a String to the specified length If the String is too long, 
	 * it will be trimmed. If the String ends in "()", leftPad() assumes it 
	 * is a function name, and will retain the suffix even if these characters 
	 * would normally be removed due to the String being too long.
	 *
	 * @return The padded String
	 */
	private String rightPad() {
		final String F = "rightPad";
//		if (this.getUnmodifiedString().length() > this.getWidth()) {
//			if (this.getUnmodifiedString().substring(this.getUnmodifiedString().length() - 2, this.getUnmodifiedString().length()).equals("()")) {
//				return String.format("%-" + (this.getWidth() - 3) + "." + (this.getWidth() - 3) + "s", this.getUnmodifiedString()) + "…()";
//			} else {
//				return String.format("%-" + (this.getWidth() - 1) + "." + (this.getWidth() - 1) + "s", this.getUnmodifiedString()) + "…";
//			}
//		} else if (this.getUnmodifiedString().length() == 2) {
//			return String.format("%-" + this.getWidth() + "." + this.getWidth() + "s", "");
//		} else {
//			return String.format("%-" + this.getWidth() + "." + this.getWidth() + "s", this.getUnmodifiedString());
//		}
		StringBuilder sb = new StringBuilder();
		if (this.getUnmodifiedString().length() == this.getWidth()) {
			//string is ALREADY the right length...
			return this.getUnmodifiedString();
		} else if (this.getUnmodifiedString().length() < this.getWidth()) {
			//string is too short...
			sb.append(this.getUnmodifiedString());
			for (int i = this.getUnmodifiedString().length(); i < this.getWidth(); i++) {
				//add the amount of characters required....
				sb.append(this.pc);
			}
		} else if (this.getUnmodifiedString().length() > this.getWidth()) {
			//string is too long...
			if (this.getUnmodifiedString().substring(this.getUnmodifiedString().length() - 2, this.getUnmodifiedString().length()).equals("()")) {
				//string is a function name...
				sb.append(this.getUnmodifiedString().substring(0, this.getWidth() - 3));
				sb.append("…()");
			} else {
				//string is not a function name...
				sb.append(this.getUnmodifiedString().substring(0, this.getWidth() - 1));
				sb.append("…");
			}
		}
		if (sb.length() != this.getWidth()) {
			JOptionPane.showMessageDialog(null, "Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
		}
		return sb.toString();
	}

	/**
	 * Gets the pad side.
	 *
	 * @return The side to pad on of the Padder.
	 */
	public String getPadSide() {
		final String F = "getPadSide";
		switch (this.ps) {
		case 0:
			return "left";
		case 1:
			return "right";
		case 2:
			return "center";
		default:
			return "?";
		}
	}

	/**
	 * Sets the pad side.
	 *
	 * @param ps The new side to pad on.
	 */
	public void setPadSide(String ps) {
		final String F = "setPadSide";
		switch (ps) {
		case "left":
			this.ps = 0;
			break;
		case "right":
			this.ps = 1;
			break;
		case "center":
			this.ps = 2;
			break;
		default:
			this.ps = 2;
		}
	}

	/**
	 * Gets the resulting width of the string, after padding.
	 *
	 * @return The resulting width of the resulting String of the Padder.
	 */
	public int getWidth() {
		final String F = "getWidth";
		return width;
	}

	/**
	 * Sets the desired resulting width of the string, after padding.
	 *
	 * @param ml The new maximum length of the resulting String.
	 */
	public void setWidth(int ml) {
		final String F = "setWidth";
		this.width = ml;
	}

	/**
	 * Gets the pad character in use by this Padder.
	 * 
	 * @return The character used by this Padder to pad strings.
	 */
	public String getPadCharacter() {
		final String F = "getPadCharacter";
		return pc;
	}

	/**
	 * Sets the pad character in use by this Padder.
	 * 
	 * @param pc The desired character used by this Padder to pad strings.
	 */
	public void setPadCharacter(String pc) {
		final String F = "setPadCharacter";
		this.pc = pc;
	}

}
