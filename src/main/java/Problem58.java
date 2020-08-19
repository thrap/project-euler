import utils.Euler;

public class Problem58 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		double primes = 0;
		double numbers = 1;
		for (int x = 3; true; x+=2) {
			for (int i = 0; i < 4; i++) {
				if (Euler.isPrime(x*x - (x-1)*i))
					++primes;
				++numbers;
			}
			if (primes/numbers <= 0.1)
				return x;
		}
	}
}
