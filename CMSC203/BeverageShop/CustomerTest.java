package assignment6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer c1,c2;
	@Before
	public void setUp() throws Exception {
		 c1 = new Customer("name1", 10);
	}

	@After
	public void tearDown() throws Exception {
		
		c1=null;
	}

	@Test
	public void testConstructor() {
		
		Customer c2  = new Customer(c1);
		
		assertFalse(c1 == c2);
		c2.setCustomerName("name2");
		c2.setCustomerAge(20);
		assertFalse(c2.getCustomerName().equals(c1.getCustomerName()));
		assertFalse(c2.getCustomerAge() == c1.getCustomerAge());
		 
	}

	 
		


}