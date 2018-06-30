/**
 * 
 */
package com.aastorp.linguistics;

/**
 * Attempts to correctly inflect nouns based on their amounts.
 *
 * @author Bjørn Aastorp
 */
public class Inflector extends Linguist {
	
	/** The noun to inflect */
	private String noun;
	
	/** The amount of the noun */
	private Object amount;
	
	/**
	 * Instantiates a new Inflector.
	 *
	 * @param noun The noun this Inflector will inflect.
	 * @param amount The amount this Inflector will inflect the noun to.
	 */
	public Inflector(String noun, Object amount) {
		this.setNoun(noun);
		this.setAmount(amount);
	}
	
	/**
	 * Gets the plural-suffixed noun.
	 *
	 * @return The suffixed noun
	 */
	private String getSuffixedNoun() {
		if (this.getNoun().equals("sheep")) {
			return this.getNoun();
		}
		if (this.getNoun().substring(this.getNoun().length() - 1, this.getNoun().length()).equals("y") || this.getNoun().substring(this.getNoun().length() - 1, this.getNoun().length()).equals("Y")) {
			return this.getNoun().substring(0, this.getNoun().length() - 1) + "ies";
		} else if (this.getNoun().substring(this.getNoun().length() - 2, this.getNoun().length()).equals("ss")) {
			return this.getNoun() + "es";
		} else {
			return this.getNoun() + "s";
		}
	}

	/* (non-Javadoc)
	 * @see com.aastorp.linguistics.Linguist#work()
	 */
	@Override
	public Object work() {
		final String F = "work";
		if 
		(
			this.getAmount().getClass() == int.class ||
			this.getAmount().getClass() == Integer.class
		) 
		{
			if ((int)this.getAmount() == 1) return this.getNoun(); else return getSuffixedNoun();
		} 
		else if
		(
			this.getAmount().getClass() == long.class ||
			this.getAmount().getClass() == Long.class
		)
		{
			if ((long)this.getAmount() == (long)1) return this.getNoun(); else return getSuffixedNoun();
		}
		else if
		(
			this.getAmount().getClass() == double.class ||
			this.getAmount().getClass() == Double.class 
		)
		{
			if (Math.floor(Double.valueOf((Double)this.getAmount())) == 1) return this.getNoun(); else return getSuffixedNoun();
		}
		else if 
		(
			this.getAmount().getClass() == String.class
		)
		{
			if (Math.floor(Integer.valueOf((String)this.getAmount())) == 1) return this.getNoun(); else return getSuffixedNoun();
		}
		else return "Inflector cannot pluralise this.";
	}

	/**
	 * Gets the unit.
	 *
	 * @return The noun of the Inflector
	 */
	public String getNoun() {
		final String F = "getNoun";
		return noun;
	}

	/**
	 * Sets the noun.
	 *
	 * @param noun The new noun.
	 */
	public void setNoun(String noun) {
		final String F = "setNoun";
		this.noun = noun;
	}

	/**
	 * Gets the amount.
	 *
	 * @return The amount of the Inflector
	 */
	public Object getAmount() {
		final String F = "getAmount";
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount The amount of the Inflector to set
	 */
	public void setAmount(Object amount) {
		final String F = "setAmount";
		this.amount = amount;
	}
	
}
