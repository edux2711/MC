package assignment5;

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility extends Object{
	
	//methods:
	
	// returns a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
	public static double[][] readFile(File file) {
		double[][] arr = new double[6][6];  
		String line = null;
		//System.out.println("Conooooo");
		
		try {
			//System.out.println(file.getName());
			File readFile = new File(file.getName());
			Scanner in = new Scanner(readFile);
			
			for (int row = 0; in.hasNextLine(); row++) {
				line = in.nextLine();
				String[] str = line.split(" ");
				arr[row] = new double[str.length];
				for (int col = 0; col < str.length; col++) {
					arr[row][col] = Double.parseDouble(str[col]);
					//System.out.println(arr[row][col]);
				}
			}		
		}
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.jijijijiji");
		      e.printStackTrace();
		}
		//System.out.println(arr.length);
		return arr;
	}
	
	//Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	public static void writeToFile(double[][] data, File outputFile) {
		try {
			FileWriter writer = new FileWriter(outputFile);
			PrintWriter pw = new PrintWriter(writer);
			for(int row = 0; row < data.length; row++) {
				for(int col = 0; col < data[row].length; col++) {
					pw.write(data[row][col] + " ");
				}
				pw.println();

			}
			pw.close();
		}
		catch (IOException e){
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	//	Returns the total of all the elements of the two dimensional array
	public static double getTotal(double[][] data) {
		double total = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	//	Returns the average of the elements in the two dimensional array
	public static double getAverage(double[][] data) {
		int numsInArray = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				numsInArray++;
			}
		}
		double avg = getTotal(data) / numsInArray;
		return avg;
	}

	//Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getRowTotal(double[][] data, int r) {
		double rowTotal = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length && row == r; col++) {
				//System.out.println(data[row][col]);
				rowTotal += data[row][col];
			}
		}
		return rowTotal;
	}
	
	//Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	public static double getColumnTotal(double[][] data, int c) {
		double colTotal = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if (col == c) {
					colTotal += data[row][col];

				}
			}
		}
		//System.out.println(colTotal);
		return colTotal;
	}
	
	//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getHighestInRow(double[][] data, int r) {
		double highest = data[r][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(highest < data[row][col] && row == r) {
					 highest = data[row][col];
				 }
			}
		}
		return highest;	

	}
	
	//Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static int getHighestInRowIndex(double[][] data, int r) {
		int highestInRowIndex = 0;
		double highest = data[r][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(highest < data[row][col] && row == r) {
					 highest = data[row][col];
					 highestInRowIndex = col;
				 }
			}
		}
     	//System.out.println(highestInRowIndex);
		return highestInRowIndex;		
	}
	
	//Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static double getLowestInRow(double[][] data, int r) {
		double lowest = data[r][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(lowest > data[row][col] && row == r) {
					 lowest = data[row][col];
				 }
			}
		}
		return lowest;			
	}
	
	//Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	public static int getLowestInRowIndex(double[][] data, int r) {
		int lowestInRowIndex = 0;
		double lowest = data[r][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(lowest > data[row][col] && row == r) {
					 lowest = data[row][col];
					 lowestInRowIndex = col;
				 }
			}
		}
		//System.out.println(lowestInRowIndex);
		return lowestInRowIndex;
	}
	
	//Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	public static double getHighestInColumn(double[][] data, int c) {
		double highest = data[c][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(highest < data[row][col] && col == c) {
					 highest = data[row][col];
				 }
			}
		}
		return highest;	
	}
	
	//Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	public static int getHighestInColumnIndex(double[][] data, int c) {
		double highest = data[c][0];
		int highestInColumnIndex = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(highest < data[row][col] && col == c) {
					 highest = data[row][col];
					 highestInColumnIndex = row;
				 }
			}
		}
		return highestInColumnIndex;
	}
	
	//Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	public static double getLowestInColumn(double[][] data, int c) {
		double lowest = data[c][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(lowest > data[row][col] && col == c) {
					 lowest = data[row][col];
				 }
			}
		}
		return lowest;
	}
	
	//Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	public static int getLowestInColumnIndex(double[][] data, int c) {
		double lowest = data[c][0];
		int lowestInColumnIndex = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(lowest > data[row][col] && col == c) {
					 lowest = data[row][col];
					 lowestInColumnIndex = row;
				 }
			}
		}
		return lowestInColumnIndex;
	}
	
	//	Returns the largest element in the two dimensional array
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(highest < data[row][col]) {
					 highest = data[row][col];
				 }
			}
		}
		return highest;		
	}
	
	//	Returns the smallest element in the two dimensional array
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				 if(lowest > data[row][col]) {
					 lowest = data[row][col];
				 }
			}
		}
		return lowest;	
	}
}




















