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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BevShop implements BevShopInterface{
	
	private int numOfAlcoholDrink = 0;
	ArrayList<Order> orders = new ArrayList<Order>();

	@Override
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) 
			return true;
		else 
			return false;
	}

	@Override
	public boolean eligibleForMore() {
		if(orders.get(orders.size()-1).findNumOfBeveType(TYPE.ALCOHOL) >= 3) 
			return false;
		else
			return true;
	}

	@Override
	public boolean validAge(int age) {
		return (age > MIN_AGE_FOR_ALCOHOL) ? true : false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Order order = new Order(time, day, customerName, customerAge);
		orders.add(order);
		numOfAlcoholDrink = 0;
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		getCurrentOrder().addNewBeverage(bevName, size);
		numOfAlcoholDrink = getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL);
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);	
	}

	@Override
	public int findOrder(int orderNo) {
		int num = 0;
		for(Order o : orders) 
			if(o.getOrderNum() == orderNo) {
				//System.out.println(o);
				//System.out.println("alo"+orders.indexOf(o));
				num = orders.indexOf(o);
				break;
			} else {
				num = -1; // not found
			}
		//System.out.println("ola" + num);
		return num;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		//System.out.println(orders.get(findOrder(orderNo)));
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for(Order o : orders) {
			total += o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		Collections.sort(orders);
	}
	
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Order o : orders) 
			str += o;
		
		return "Orders: "             + str + "\n" +
			   "Total monthly sale: " + totalMonthlySale();
		
	}

	//getters and setters
	public int MAX_ORDER_FOR_ALCOHOL() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int MIN_AGE_FOR_ALCOHOL() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}

	public boolean isMaxFruit(int fruit) {
		return (fruit > 5) ? true : false;
	}
	
	public int totalNumOfMonthlyOrders() {
		//return the order number of the last order in the sorted list
		return orders.get(orders.size()-1).getOrderNum();
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}

	public void setNumOfAlcoholDrink(int numOfAlcoholDrink) {
		this.numOfAlcoholDrink = numOfAlcoholDrink;
	}

	

	

	

}
