package Java;

public class Problem436 {
	public static void main(String[] args) {
		int turns = 1000000;
		int wins = 0;
		for (int i = 0; i < turns; i++) {
			double S = 0;
			double x = 0, y = 0;
			while(S <= 1) {
				x = Math.random();
				S+=x;
			}
			while(S <= 2) {
				y = Math.random();
				S+=y;
			}
			if (y > x) 
				wins++;
		}
		System.out.println((1.0*wins)/turns);
	}
}
