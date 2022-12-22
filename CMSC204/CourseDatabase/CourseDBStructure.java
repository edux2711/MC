import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	//Load factor for the assignment
	private final double LOAD_FACTOR = 1.5;
	private int size;
		
	//Array implementation of hashTable
	LinkedList<CourseDBElement> hashTable[];
	
	public CourseDBStructure(int estimateSize) {

		int sizeOverLoadFactor = (int) (estimateSize / LOAD_FACTOR);

		//size of the table will be a prime number higher than estimateSize.
		size = find_4kPlus3Prime(sizeOverLoadFactor);
		hashTable = new LinkedList[size];
	}
	
	public CourseDBStructure(String testing, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElement object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		//get the index position of the element
		int index = getIndex(element.getCRN());
		System.out.println(index + "!!!!!!!!!!!!!!");
		//create a link list at the index location
		hashTable[index] = new LinkedList<CourseDBElement>();
		
		//add element to the linked list
		hashTable[index].add(element);
		
	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		int index = getIndex(crn);
		
		if(hashTable[index] == null)
			throw new IOException();
		
		for(int i = 0; i < hashTable[index].size(); i++) {
			CourseDBElement f = (CourseDBElement) hashTable[index].get(i);
			if(crn == f.getCRN()) 
				return f;
		}

		throw new IOException();
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
		ArrayList<String> list = new ArrayList<>();
		CourseDBElement ref = null;
		
		for(int i = 0; i < size; i++) {
			if(hashTable[i] != null) {
				for(int j = 0; j < hashTable[i].size(); j++)
					ref = (CourseDBElement) hashTable[i].get(j);
					list.add(ref.toString());
			}
			
		}
		
		return list;
	}
	

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return (int)size;
	}
	
	//Takes an integer crn value and returns its index location in the hashTable.
	public int getIndex(int crn) {
		
		int index = hash(crn) % (int)size;
		
		if(index < 0) 
			index += (int)size;
		return index;
	}
	
	//Take and integer crn, convert into String and return its hash code value
	public int hash(int crn) {
		String crnStr = Integer.toString(crn);
		return crnStr.hashCode();
	}
	
	//takes the n/loadFactor value and return the next 4k+3 prime number based on the value.
	public int find_4kPlus3Prime(int num){
		boolean found = false;
		int k1, 
			n = num;
		double k2;
	
		//If num is not a 4k+3 prime, check the numbers above num
		while (found == false) {

			if(isPrime(n) == false) {
				n++;
				continue;
			}
					    
			k1 = (n - 3) / 4;
			k2 = ((double)n - 3) / 4;  
			
			//If the calculation of k as an int is equal to the calculation of k as a double
			//then it means that k must be an integer and therefore it is a 4k+3 prime
			if(k1 == k2) {
				found = true;
				break;
			}
			n++;
		}
		//System.out.println("Returning n:" + n);
		return n;
	}
	
	public boolean isPrime(int n) {
		  //corner case
	    if (n <= 1) return false;
	    
	    //check from 2 to square_root(n)
	    for(int i = 2; i <= Math.sqrt(n); i++) {
	        if(n % i == 0)
	            return false;
	    }
	    return true;
	}
	

}
