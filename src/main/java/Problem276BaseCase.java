import utils.Euler;

public class Problem276BaseCase {
	public static void main(String[] args) {
		int limit = 1000;
		int count = 0;
		for (int a = 1; 3*a <= limit; a++) {
			for (int b = a; a+2*b <= limit; b++) {
				for (int c = b; a+b+c <= limit && c < a+b; c++) {
					if (Euler.gcd(a, Euler.gcd(b, c)) == 1)
						count++;
				}
			}
		}
		System.out.println(count);
	}
}
