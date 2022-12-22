package prisonertest;

public class Prisoner {
	//Fields:
	public String name;
	public double height;
	public int sentence;
	
	//Method
	public void think() {
		System.out.println("I am aware of my sins and I will be better.");
	}
	
	public void print() {
		print(false);
	}
	public void print(boolean x) {
		if (x == true) {
			think();
		}
		System.out.println("Name: " + name);
		System.out.println("Height: " + height);
		System.out.println("Sentence: " + sentence);
	}
	
	//Constructor
	public Prisoner(String name, double height, int sentence){
		System.out.println("This is constructor 1");
		this.name = name;
		this.height = height;
		this.sentence = sentence;
	}
	
	public Prisoner(){
		System.out.println("This is constructor 2");

	}

}
