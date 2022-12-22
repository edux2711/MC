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

public class Customer {
	
	private String customerName;
	private int customerAge;

	public Customer(String customerName, int customerAge) {
		this.customerName = customerName;
		this.customerAge = customerAge;
	}

	public Customer(Customer c) {

	    this(c.getCustomerName(), c.getCustomerAge());
	}
	
	@Override
	public String toString() {
		return "Customer name: " + customerName + "\n" +
		       "Customer age: "  + customerAge  + "\n" ;
	}
	//getters and setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}


}
