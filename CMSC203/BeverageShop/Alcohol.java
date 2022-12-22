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

public class Alcohol extends Beverage{
	
	private boolean isOfferedInWeekend = false;
	private final double WEEKEND_DRINK = 0.6;

	public Alcohol(String beverageName, SIZE size, boolean offerendWeekend) {
		super(beverageName, TYPE.ALCOHOL, size);
		this.isOfferedInWeekend = offerendWeekend;
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
		
		//add WEEKEND_DRINK to price if isOfferedInWeekend is true
		price += (isOfferedInWeekend) ? WEEKEND_DRINK : 0;
		
		return price;
	}

	@Override
	public String toString() {

		return 
				   super.toString()                                + "\n" +
				   "Offered in the weekend: " + isOfferedInWeekend + "\n" +
				   "Price: "                  + calcPrice()        + "\n" ;
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
        Alcohol alcohol = (Alcohol)obj;
        
		if (super.equals(alcohol) 
					&& 
			alcohol.isOfferedInWeekend == isOfferedInWeekend) 
		{
			return true;
		} else {
			return false;	
		}
	}

	public boolean isOfferedInWeekend() {
		return isOfferedInWeekend;
	}

	public void setOfferedInWeekend(boolean isOfferedInWeekend) {
		this.isOfferedInWeekend = isOfferedInWeekend;
	}

	public double getWEEKEND_DRINK() {
		return WEEKEND_DRINK;
	}

}
