package assignment4;

import java.util.*;

public class ManagementCompany extends Object{
	
	//fields
	private final int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name, taxID;
	List<Property> properties;
	private Plot plot;
	
	//constructors
	ManagementCompany(){
		name  = null;
		taxID = null;
		plot  = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new ArrayList<Property>();
	}
	
	ManagementCompany(String name, String taxID, double mgmFee){
		this.name      = name;
		this.taxID     = taxID;
		this.mgmFeePer = mgmFee;
		plot  = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new ArrayList<Property>();
	}
	
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		this.name      = name;
		this.taxID     = taxID;
		this.mgmFeePer = mgmFee;
		plot  = new Plot(x, y, width, depth);
		properties = new ArrayList<Property>();
	}
	
	ManagementCompany(ManagementCompany otherCompany){
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = new Plot(otherCompany.plot);
		properties = new ArrayList<Property>();
	}

	//methods
	public int addProperty(Property property) {
		
		Property propertyCopy = new Property(property);
		//System.out.println(properties.size() + "This is addproperty1");
		if(properties.size() == getMAX_PROPERTY())
			return -4; // array is full
		else if(propertyCopy == null) 
			return -2; //property object is null
		else if(plot.encompasses(propertyCopy.getPlot()) == false)
			return -3;	
		for(int i = 0; i < properties.size(); i++)
			if(propertyCopy.getPlot().overlaps(properties.get(i).getPlot())) {				
				return -4;
			}
		
		//if no errors occur, add the copy of the property to the array
		properties.add(propertyCopy);
		//System.out.println();
		return properties.indexOf(propertyCopy);
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		
		Property property = new Property(name, city, rent, owner);
		
		if(properties.size() == getMAX_PROPERTY())
			return -4; // array is full
		else if(property == null) 
			return -2; //property object is null
		else if(plot.encompasses(property.getPlot()) == false)
			return -3;
		for(int i = 0; i < properties.size(); i++)
			if(property.getPlot().overlaps(properties.get(i).getPlot())) {
				return -4;
			}
		
		//if no errors occur, add the copy of the property to the array
		properties.add(property);
		return properties.indexOf(property);
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);

		if(properties.size() == getMAX_PROPERTY())
			return -4; // array is full
		else if(property == null) 
			return -2; //property object is null
		else if(plot.encompasses(property.getPlot()) == false)
			return -3;
			
		for(int i = 0; i < properties.size(); i++)
			if(property.getPlot().overlaps(properties.get(i).getPlot())) {
				return -4;
			}
		
		//if no errors occur, add the copy of the property to the array
		properties.add(property);
		return properties.indexOf(property);
	}

	//This method finds the property with the maximum rent amount and returns its toString result
	public double maxRentProp() {
		double maxRent = 0;		
		for(int i = 0; i < properties.size(); i++)
			if(maxRent < properties.get(i).getRentAmount()) {
				maxRent = properties.get(i).getRentAmount();
			}
		return maxRent;
	}
	
	//Goes through the array of properties and find the index of the property with the highest rent amount
	private int maxRentPropertyIndex() {
		double maxRent = 0;
		int index = 0;
		for(int i = 0; i < properties.size(); i++)
			if(maxRent < properties.get(i).getRentAmount()) {
				maxRent = properties.get(i).getRentAmount();
				index = properties.indexOf(properties.get(i));
			}
		return index;
	}
	
	//Display the information of the property at the index passed to the parameter call
	private String displayPropertyAtIndex(int i){
		return "Property Name: " + properties.get(i).getPropertyName() + "\n" +
			   "Located in "     + properties.get(i).getCity()         + "\n" +
		       "Belonging to "   + properties.get(i).getOwner()        + "\n" +
			   "Rent Amount : "  + properties.get(i).getRentAmount()   + " ";
	}
	
	//goes through the array of properties and finds to total rent
	public double totalRent() {
		double rentTotal = 0;
		for(int i = 0; i < properties.size(); i++)
			rentTotal += properties.get(i).getRentAmount();
		return rentTotal;
	}
	
	
	//getter methods
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	//toString
	@Override
	public String toString() {
		double totalManagementFee = totalRent() * (mgmFeePer / 100);
		String finalStatement = "List of properties for " + name + ", taxID: " + taxID + 
				             "\n_____________________________________________\n";
		for (int i = 0; i < properties.size(); i++) {
			finalStatement += properties.get(i).toString();
		}
		finalStatement += "_____________________________________________\n" +
		                  "Total management Fee: " + totalManagementFee;
		
		return finalStatement;
	}
	
}
