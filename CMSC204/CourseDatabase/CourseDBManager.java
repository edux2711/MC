import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	
	private CourseDBElement cde;
	private CourseDBStructure cds = new CourseDBStructure(13);

	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		cde = new CourseDBElement(id, crn, credits, roomNum, instructor);	
		cds.add(cde);
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the information of courses from a text file and adds them
	 * to the CourseDBStructure data structure
	 * @param input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException  {

		Scanner file = null;
		String line = "";
		String[] splitString;
		
		file = new Scanner(input);

		while(file.hasNext()) {
			 line = file.nextLine();
			 splitString = line.split(" ");
			 cde = new CourseDBElement(splitString[0], Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2]), splitString[3], splitString[4]);
			 cds.add(cde);
		}
		file.close();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}

}
