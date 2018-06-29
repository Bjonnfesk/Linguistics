/**
 * 
 */
package com.aastorp.linguistics;

/**
 * Correctly inflects nouns based on their amounts.
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
		this.setUnit(noun);
		this.setAmount(amount);
	}
	
	/**
	 * Gets the plural-suffixed unit.
	 *
	 * @return The suffixed unit
	 */
	private String getSuffixedUnit() {
		if (this.getUnit().equals("sheep")) {
			return this.getUnit();
		}
		if (this.getUnit().substring(this.getUnit().length() - 1, this.getUnit().length()).equals("y") || this.getUnit().substring(this.getUnit().length() - 1, this.getUnit().length()).equals("Y")) {
			return this.getUnit().substring(0, this.getUnit().length() - 1) + "ies";
		} else if (this.getUnit().substring(this.getUnit().length() - 2, this.getUnit().length()).equals("ss")) {
			return this.getUnit() + "es";
		} else {
			return this.getUnit() + "s";
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
			if ((int)this.getAmount() == 1) return this.getUnit(); else return getSuffixedUnit();
		} 
		else if
		(
			this.getAmount().getClass() == long.class ||
			this.getAmount().getClass() == Long.class
		)
		{
			if ((long)this.getAmount() == (long)1) return this.getUnit(); else return getSuffixedUnit();
		}
		else if
		(
			this.getAmount().getClass() == double.class ||
			this.getAmount().getClass() == Double.class 
		)
		{
			if (Math.floor(Double.valueOf((Double)this.getAmount())) == 1) return this.getUnit(); else return getSuffixedUnit();
		}
		else if 
		(
			this.getAmount().getClass() == String.class
		)
		{
			if (Math.floor(Integer.valueOf((String)this.getAmount())) == 1) return this.getUnit(); else return getSuffixedUnit();
		}
		else return "Inflector cannot pluralise this.";
	}

	/**
	 * Gets the unit.
	 *
	 * @return The noun of the Inflector
	 */
	public String getUnit() {
		final String F = "getUnit";
		return noun;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		final String F = "setUnit";
		this.noun = unit;
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
