package assignment5;

public class HolidayBonus extends Object{
	
	//methods:
	
	//Calculates the holiday bonus for each store
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonusArray = new double[data.length];
		double highest = 0, highIndex = 0, 
				lowest = 0, lowIndex = 0;
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col ++) {
				highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				lowest  = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
				lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
				//System.out.println("Highest in column #" + col + ": " + highest + " index: " + highIndex);
				//System.out.println("Lowest in column #" + col + ": " + lowest + " index: " + lowIndex);
				//System.out.println();
				
				if(highIndex == row && highest > 0) {
					bonusArray[row] += high;
				} else if(lowIndex == row && lowest > 0) {
					bonusArray[row] += low;
				} else if (data[row][col] > 0){
					bonusArray[row] += other;
				}
			}
		}
		for(int i = 0; i < bonusArray.length; i++) {
			//System.out.println(bonusArray[i]);
		}
		System.out.println();
		return bonusArray;
	}
	
	//Calculates the total holiday bonuses
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double totalBonus = 0;
		for(int i = 0; i < data.length; i++) {
			totalBonus += calculateHolidayBonus(data, high, low, other)[i];
			//System.out.println(totalBonus);
		}
		return totalBonus;
	}
}
