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

public abstract class Beverage {
	private String beverageName = "";
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0,
						 SIZE_PRICE = 1.0;
	
	public Beverage(String beverageName, TYPE type, SIZE size) {
		this.beverageName = beverageName;
		this.type = type;
		this.size = size;
	}
	
	//calculates and returns beverage price
	public abstract double calcPrice();
	
	//returns string representation for Beverage including the name and size
	public String toString() {
		
		return "Name: " + getBeverageName() + "\n" + 
			   "Size: " + getSize()         	   ;
	}
	
	//checks equality based on name, type, size of the beverage
	public boolean equals(Object obj) {
		
		//if obj is compared with itself  return true 
        if (obj == this) {
            return true;
        }
        
        // if obj is an instance of Beverage or not
        if (!(obj instanceof Beverage)) {
            return false;
        }
		
        //change obj to a beverage object in order to compare contents
        Beverage bev = (Beverage)obj;
        
        //compare contents
		if(bev.getBeverageName().equals(beverageName) 
				              && 
		           bev.getType() == type
		                      && 
		           bev.getSize() == size            )
		{
			return true;
		} else {
			return false;
		}		
		
	}

	//getters and setters:
	public String getBeverageName() {
		return beverageName;
	}

	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}
	
	
}
