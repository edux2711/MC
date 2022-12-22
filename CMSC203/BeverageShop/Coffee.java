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

public class Coffee extends Beverage{
	
	private boolean isExtraCoffeeShot = false;
	private final double EXTRA_COFFEE_PRICE = 0.5;
	
	private boolean isExtraSyrup = false;
	private final double EXTRA_SYRUP = 0.5;

	public Coffee(String beverageName, SIZE size, boolean coffeeShot, boolean syrup) {
		super(beverageName, TYPE.COFFEE, size);
		this.isExtraCoffeeShot = coffeeShot;
		this.isExtraSyrup      = syrup;
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
		
		//add EXTRA_COFFEE_PRICE to price if isExtraCoffeeShot is true
		price += (isExtraCoffeeShot) ? EXTRA_COFFEE_PRICE : 0;
		//add isExtraSyrup to price if EXTRA_SYRUP is true
		price += (isExtraSyrup)      ? EXTRA_SYRUP        : 0;
		
		return price;
	}

	
	//String representation of Coffee beverage, including the name, size, 
	//whether it contains extra shot, extra syrup and the price of the coffee
	@Override
	public String toString() {
		
		return 
			   super.toString()                               + "\n" +
			   "Contains extra shot: "  + isExtraCoffeeShot   + "\n" +
		       "Contains extra syrup: " + isExtraSyrup        + "\n" +
			   "Price: "                + calcPrice()         + "\n" ;
	}
	
	//checks equality based on the Beverage class equals method and additional instance variables for this class.
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
        Coffee coffee = (Coffee)obj;
        
		if (super.equals(coffee) 
					&& 
			coffee.isExtraCoffeeShot == isExtraCoffeeShot
					&&
			coffee.isExtraSyrup == isExtraSyrup) {
			
			return true;
		} else {
			return false;	
		}
	}

	
	
	//getters and setters
	public boolean isExtraCoffeeShot() {
		return isExtraCoffeeShot;
	}

	public void setExtraCoffeeShot(boolean extraCoffeeShot) {
		this.isExtraCoffeeShot = extraCoffeeShot;
	}

	public boolean isExtraSyrup() {
		return isExtraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.isExtraSyrup = extraSyrup;
	}

	public double getEXTRA_COFFEE_PRICE() {
		return EXTRA_COFFEE_PRICE;
	}

	public double getEXTRA_SYRUP() {
		return EXTRA_SYRUP;
	}

	
	
	

	
	
}
