package assignment5;



import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{-2,-1,0,1,2}, 
										 {-3,-2,-1,0 },
										 {3,4,5      }};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(6.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		//fail("Student testGetTotal not implemented");	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(0.5,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		//fail("Student testGetAverage not implemented");	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(12.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,2),.001);
		//fail("Student testGetRowTotal not implemented");	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(-2.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.001);
		//fail("Student testGetColumnTotal not implemented");	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(5,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		//fail("Student testGetHighestInArray not implemented");	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		try {
			inputFile = new File("TestStudent.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("5.1 6.2 1.3\n" +
						 "-3.9 10.0\n"  	   +
						 "-2.3 7.5\n"      +
						 "-4.2 2.6");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(5.1, array[0][0],.001);
			assertEquals(6.2, array[0][1],.001);
			assertEquals(1.3, array[0][2],.001);
			assertEquals(-3.9, array[1][0],.001);
			assertEquals(10.0, array[1][1],.001);
			assertEquals(-2.3, array[2][0],.001);
			assertEquals(7.5, array[2][1],.001);
			assertEquals(-4.2, array[3][0],.001);
			assertEquals(2.6, array[3][1],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[2][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
		//fail("Student testWriteToFile not implemented");	
	}

}