package assignment4;

public class Property extends Object {
	
	//fields
	private String propertyName, owner, city;
	private double rentAmount; 
	private Plot plot;
	
	//constructors
	Property(){
		propertyName = null;
		owner = null;
		city = null;
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	Property(Property p){
		propertyName = p.propertyName;
		owner = p.owner;
		city = p.city;
		rentAmount = p.rentAmount;
		plot = new Plot(p.plot);
	}
	
	Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth ){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	//getter and setter methods
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	@Override
	public String toString() {
		return "Property Name: " + propertyName + "\n" +
			   "Located in "     + city         + "\n" +
			   "Belonging to "   + owner        + "\n" +
			   "Rent Amount : "  + rentAmount   + "\n\n";
	}
	
	
	
	
	
	
	
	
}
