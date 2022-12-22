/*
 * 
 * course name: CMSC 203
 * project number: 6
 * Eduardo Gonzalez
 * date: 4/24/22
 * platform/compiler: Eclipse
 * 
 */
package assignment6;

public class Smoothie extends Beverage{
	private int fruits;
	private final double FRUIT_PRICE = 0.5;
	
	private boolean proteinPowderAdded = false;
	private final double PROTEIN_COST = 1.5;

	//constructor
	public Smoothie(String beverageName, SIZE size, int fruits, boolean proteinPowderAdded) {
		super(beverageName, TYPE.SMOOTHIE, size);
		this.fruits = fruits;
		this.proteinPowderAdded = proteinPowderAdded;
	}

	@Override
	public double calcPrice() {

		double price = 0.0;
		switch(getSize()) {
			case SMALL: 
				price += getBASE_PRICE();
				break;
			case MEDIUM:
				price += getBASE_PRICE() + getSIZE_PRICE();
				break;
			case LARGE:
				price += getBASE_PRICE() + (2 * getSIZE_PRICE());	
		}
		
		//add FRUIT_PRICE to price depending on the number of fruits
		for(int i = 0; i < fruits; i++) {
			price += FRUIT_PRICE;
		}
		
		//add PROTEIN_COST to price if proteinPowderAdded is true
		price += (proteinPowderAdded) ? PROTEIN_COST : 0;
		
		return price;
	}

	@Override
	public String toString() {
		
		return     super.toString()                         + "\n" +
				   "Protein added:"    + proteinPowderAdded + "\n" +
				   "Number of fruits:" + fruits             + "\n" +
				   "Price: "           + calcPrice()        + "\n" ;	
		
	}

	@Override
	public boolean equals(Object obj) {
		
		//if obj is compared with itself  return true 
        if (obj == this) {
            return true;
        }
        
        // if obj is an instance of Coffee or not
        if (!(obj instanceof Beverage)) {
            return false;
        }
		
        //change obj to a coffee object in order to compare contents
        Smoothie smoothie = (Smoothie)obj;
        
		if (super.equals(smoothie) 
					&& 
			smoothie.fruits == fruits
					&&
			smoothie.proteinPowderAdded == proteinPowderAdded) {
			
			return true;
		} else {
			return false;	
		}
	}
	
	
	//getters and setters:
	public int getFruits() {
		return fruits;
	}

	public void setFruits(int fruits) {
		this.fruits = fruits;
	}

	public boolean isProteinPowderAdded() {
		return proteinPowderAdded;
	}

	public void setProteinPowderAdded(boolean proteinPowderAdded) {
		this.proteinPowderAdded = proteinPowderAdded;
	}

	public double getFRUIT_PRICE() {
		return FRUIT_PRICE;
	}

	public double getPROTEIN_COST() {
		return PROTEIN_COST;
	}


}
