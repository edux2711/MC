package primitiveCastingPractice;

public class TypeCasting {

	public static void main(String[] args) {
		
		int i = 10;
		double e = i;
		//10 changes to 10.0
		System.out.println(i + " changes to " + e);
		
		double a = 100.2;
		int b = (int) a;
		//100.2 changes to 100
		System.out.println(a + " changes to " + b);
		
		String x = "65000";
		//changes the variable from a string to an integer
		int y = Integer.parseInt(x);
		System.out.println(y);

	}
}
