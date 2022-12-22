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

import java.util.*;

public class Order implements OrderInterface, Comparable<Order>{
	
	private static int count = 0;
	private int orderNum;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	
	public Order(int orderNum, DAY day, Customer customer) {
		this.orderNum = orderNum;
		this.orderDay = day;
		this.customer = new Customer(customer.getCustomerName(), customer.getCustomerAge());
	}
	
	public Order(int time, DAY day, String customerName, int customerAge) {
		this.orderNum = setCount(getCount() + 1);
		//System.out.println(getCount());
		this.orderTime = time;
		this.orderDay = day;
		this.customer = new Customer(customerName, customerAge);
	}

	@Override
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
			return true;
		else 
			return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		beverageList.add(c);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol a = new Alcohol(bevName, size, isWeekend());
		beverageList.add(a);		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverageList.add(s);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage bev : beverageList) {
			total += bev.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for(Beverage bev : beverageList) {
			if(bev.getType() == type) {
				count++;
			}
		}
		return count;
	}

	@Override
	//Override the compareTo method to compare this order with another order based on the order number. 
	//Returns 0 if this order number is same as another order's order number, 1 if it is greater than 
	//another order's order number, -1 if it smaller than another order's order number.
	public int compareTo(Order o) {
		
		if(orderNum == o.orderNum)
			return 0;
		else if (orderNum > o.orderNum)
			return 1;
		else 
			return -1;
		
	}
	
	@Override
	public String toString() {
		
		//
		String listPrint = "";
		for (Beverage bev : beverageList) {
			listPrint += bev;
		}
		
		return "Order number: "  + orderNum  				   + "\n" +
		       "Order time: "    + orderTime				   + "\n" +
			   "Order day: "     + orderDay  				   + "\n" +
		       "Customer name: " + customer.getCustomerName()  + "\n" +
			   "Customer age: "  + customer.getCustomerAge()   + "\n" +
		       "\nBeverages: \n" + listPrint                   + "\n" +
			   "Order total: "   + calcOrderTotal()                   ;
		
	}
	
	public int generateRandom() {
		
		int random;
		Random rnd = new Random();
		random = rnd.nextInt(10000, 90000 + 1);
		System.out.println();
		
		return random;
	}

	//getters and setters
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}

	public int getTotalItems() {
		return beverageList.size();
	}

	public static int getCount() {
		return count;
	}

	public static int setCount(int count) {
		Order.count = count;
		return count;
	}

}
