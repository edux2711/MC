package prisonertest;

public class PrisonTest {

	public static void main(String[] args) {
		Prisoner p01 = new Prisoner("Bubba", 2.08, 4);
		Prisoner p02 = new Prisoner("Twitch", 1.73, 3);
		Prisoner p03 = new Prisoner();
		
		
		System.out.println(p01.name);
		System.out.println(p02.name);
		
		System.out.println(p03.name + "\n" + p03.height + "\n" + p03.sentence);
		p01.print();
		p01.print(true);
	}

}
