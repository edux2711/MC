package assignment4;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmCo;
	Property p1, p2, p3;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmCo = new ManagementCompany();
		//student add three properties, with plots, to mgmt co
		p1 = new Property("House", "Silver Spring", 1500, "Gonzalez", 6, 6, 1, 1);
		mgmCo.addProperty(p1);

		p2 = new Property("Apartment", "Rockville", 1000, "Castillo", 2, 2, 1, 1);
		mgmCo.addProperty(p2);

		p3 = new Property("Building", "Davie", 500, "Hamilton", 4, 4, 1, 1);
		mgmCo.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1=p2=p3=null;
		mgmCo = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//assertEquals(mgmCo.addProperty(p1), 0, 0);
		//assertEquals(mgmCo.addProperty(p2), 1, 0);
		//assertEquals(mgmCo.addProperty(p3), 2, 0);

		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(mgmCo.addProperty("Small House", "Gaithersburg", 400, "Alonso"), 3, 0);
		//student should add property with 8 args
		assertEquals(mgmCo.addProperty("Parking lot", "DC", 1000, "Wizards", 8, 8, 1, 1), 4, 0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -4
		assertEquals(mgmCo.addProperty("Store", "DC", 1000, "Wizards", 5, 5, 3, 4), -4, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmCo.maxRentProp(), 1500, 0);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmCo.totalRent(), 3000, 0);		
	}

 }