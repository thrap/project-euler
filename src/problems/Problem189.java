package problems;

public class Problem189 {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 8; i++) {
			sum+=i+i-1;
		}
		System.out.println(Math.pow(3,sum) + " antall muligheter xD");
	}
}
