/**
 * 
 */
package com.aastorp.linguistics;

/**
 * Pads a String (with spaces by default) to the specified length, either on 
 * the left side, right side or so the String is centred, trimming the String 
 * if it is too long. If the String ends in "()", Padder assumes 
 * it is a function name, and will retain the suffix even if these 
 * characters would normally be removed due to the String being 
 * too long, except when centre-padding. This Linguist understands 
 * both American and British spelling conventions.
 *
 * @author Bjørn Aastorp
 * 
 */
public class Padder extends WidthTextFormatter {
	
	/**  The side to pad on: 0 = left, 1 = right, 2 = centre. */
	private int ps;
	
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
		super(stringToPad, width);
		this.setPadSide(padSide.toLowerCase());
	}
	
	/**
	 * Instantiates a new padder.
	 *	
	 * @param stringToPad The string to pad.
	 * @param padSide The side to pad the String on. Valid values are "left", "right" and "center"/"centre".
	 * @param width The desired width of the String after padding.
	 * @param padCharacter The character(s) to pad the String with.
	 * 
	 */
	public Padder(String stringToPad, String padSide, int width, String padCharacter) {
		super(stringToPad, width);
		this.setPadSide(padSide);
		this.setPadCharacter(padCharacter);
	}
	
	/* (non-Javadoc)
	 * @see com.aastorp.linguistics.Linguist#work()
	 */
	@Override
	public Object work() {
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
		StringBuilder sb = new StringBuilder();
		if (this.getUnmodifiedString().length() == this.getWidth()) {
			//string is ALREADY the right length...
			return this.getUnmodifiedString();
		} else if (this.getUnmodifiedString().length() < this.getWidth()) {
			//string is too short...
			for (int i = this.getUnmodifiedString().length(); i < this.getWidth(); i = i + this.getPadCharacter().length()) {
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
			System.out.println("Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
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
		if (
			this.getUnmodifiedString() == null || 
			this.getWidth() <= this.getUnmodifiedString().length()
			) 
		{
			return this.getUnmodifiedString();
		}
		StringBuilder sb = new StringBuilder(this.getWidth());
		for (int i = 0; i < (this.getWidth() - this.getUnmodifiedString().length()) / 2; i = i + this.getPadCharacter().length()) {
			sb.append(this.getPadCharacter());
		}
		sb.append(this.getUnmodifiedString());
		while (sb.length() < this.getWidth()) {
			sb.append(this.getPadCharacter());
		}
		if (sb.length() != this.getWidth()) {
			System.out.println("Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
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
		StringBuilder sb = new StringBuilder();
		if (this.getUnmodifiedString().length() == this.getWidth()) {
			//string is ALREADY the right length...
			return this.getUnmodifiedString();
		} else if (this.getUnmodifiedString().length() < this.getWidth()) {
			//string is too short...
			sb.append(this.getUnmodifiedString());
			for (int i = this.getUnmodifiedString().length(); i < this.getWidth(); i = i + this.getPadCharacter().length()) {
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
			System.out.println("Got the wrong width: " + sb.length() + ", should be: " + this.getWidth());
		}
		return sb.toString();
	}

	/**
	 * Gets the pad side.
	 *
	 * @return The side to pad on of the Padder.
	 */
	public String getPadSide() {
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
	 * Gets the pad character in use by this Padder.
	 * 
	 * @return The character used by this Padder to pad strings.
	 */
	public String getPadCharacter() {
		return pc;
	}

	/**
	 * Sets the pad character in use by this Padder.
	 * 
	 * @param pc The desired character used by this Padder to pad strings.
	 */
	public void setPadCharacter(String pc) {
		this.pc = pc;
	}

}
