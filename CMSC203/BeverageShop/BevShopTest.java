package assignment6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTest {

	BevShop bevShop;
	@Before
	public void setUp() throws Exception {
		bevShop = new BevShop();
	}

	@After
	public void tearDown() throws Exception {
		bevShop = null;
		Order.setCount(0);
	}

	@Test
	public void testValidTime()
	{
		assertTrue(bevShop.validTime(8));
		assertTrue(bevShop.validTime(23));
		assertFalse(bevShop.validTime(7));
		assertFalse(bevShop.validTime(24));
	}
	 
	@Test
	public void testValidAge()
	{
		assertFalse(bevShop.validAge(21));
		assertTrue(bevShop.validAge(27));
	}
	
	@Test
	public void testStartNewOrder()
	{
		bevShop.startNewOrder(8, DAY.MONDAY, "John", 30);
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(DAY.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("John", bevShop.getCurrentOrder().getCustomer().getCustomerName());
		assertEquals(30, bevShop.getCurrentOrder().getCustomer().getCustomerAge());
		assertEquals(0,bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 0);
	
	}
	
	@Test
	public void testProcessAlcoholOrder()
	{
		bevShop.startNewOrder(8,DAY.MONDAY,"John", 30);
		
		bevShop.processAlcoholOrder("Mohito", SIZE.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBeverageName().equals("Mohito"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(SIZE.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(TYPE.ALCOHOL));	
		assertTrue(bevShop.eligibleForMore());
		bevShop.processAlcoholOrder("tonic", SIZE.MEDIUM);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBeverageName().equals("tonic"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(SIZE.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(TYPE.ALCOHOL));	
		assertTrue(bevShop.eligibleForMore());
		bevShop.processAlcoholOrder("V", SIZE.SMALL);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getBeverageName().equals("V"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getSize().equals(SIZE.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getType().equals(TYPE.ALCOHOL));	
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
		
	}
	
	@Test
	public void testProcessSmoothieOrder()
	{
		bevShop.startNewOrder(8,DAY.MONDAY,"John", 30);
		assertTrue ( bevShop.isMaxFruit(6) );
		assertFalse ( bevShop.isMaxFruit(5) );
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		
		Smoothie sm = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);
		
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBeverageName().equals("Detox"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(SIZE.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(TYPE.SMOOTHIE));
		
		
		assertTrue(sm.getFruits() == 1);
		assertFalse(sm.isProteinPowderAdded());
		 
		
		bevShop.processSmoothieOrder("Morning SunShine", SIZE.LARGE, 4, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		
		sm =  (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBeverageName().equals("Morning SunShine"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(SIZE.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(TYPE.SMOOTHIE));
		
		assertTrue(sm.getFruits() == 4);
		assertTrue(sm.isProteinPowderAdded());
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
		
	}
	
	@Test
	public void testProcessCoffeeOrder()
	{
		Coffee cf;
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBeverageName().equals("americano"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(SIZE.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(TYPE.COFFEE));
		assertTrue(cf.isExtraCoffeeShot()); 
		assertFalse(cf.isExtraSyrup()); 
		
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(1);
		
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBeverageName().equals("Cappuccino"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(SIZE.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(TYPE.COFFEE));
		assertFalse(cf.isExtraCoffeeShot()); 
		assertFalse(cf.isExtraSyrup()); 
		
	}
	
	@Test
	public void testFindOrder()
	{
	 
		int orderNum;
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		bevShop.processSmoothieOrder("Morning SunShine", SIZE.LARGE, 4, true);
		
		//this is 1
		orderNum = bevShop.getCurrentOrder().getOrderNum();
		//System.out.println(orderNum);

		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
		assertEquals(0,bevShop.findOrder(orderNum));
		
		orderNum = bevShop.getCurrentOrder().getOrderNum();
		assertEquals(1,bevShop.findOrder(orderNum));
		
	}
	@Test
	public void testTotalOrderPrice()
	{
	 	int orderNum1,orderNum2;
		
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", SIZE.LARGE,true, true);
		
		orderNum1 = bevShop.getCurrentOrder().getOrderNum();
		
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
	
		orderNum2 = bevShop.getCurrentOrder().getOrderNum();
	 
		assertEquals(11.5,bevShop.totalOrderPrice(orderNum1),.01);
		assertEquals(2.5,bevShop.totalOrderPrice(orderNum2),.01 );
		
	}
	@Test
	public void testTotalMonthlySale()
	{
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", SIZE.LARGE,true, true);
	
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
		bevShop.processAlcoholOrder("Mohito", SIZE.SMALL);
		
		bevShop.startNewOrder(12,DAY.SATURDAY,"Amy", 43);
		bevShop.processSmoothieOrder("Detox", SIZE.MEDIUM, 4, true);
		bevShop.processCoffeeOrder("Latte", SIZE.SMALL,false, false);		 

	 
		assertEquals(25.1, bevShop.totalMonthlySale(), .01 );
 
	}
	
	@Test
	public void testSortOrders()
	{
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.startNewOrder(12,DAY.SATURDAY,"Amy", 43);
		
		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNum()< bevShop.getOrderAtIndex(1).getOrderNum());	 
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNum()< bevShop.getOrderAtIndex(2).getOrderNum());
		
	}@Test
	public void testToString() {
		
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		 
	
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
			  
		 
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(0).getOrderNum()) ));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getCustomer().getCustomerName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getBeverageName()) );
		
	 	
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(1).getOrderNum()) ));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getCustomer().getCustomerName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getBeverageName()) );
		
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.totalMonthlySale() )  ));
		
 
		 
	}
}	

 