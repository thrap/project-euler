package Java;

import utils.Euler;

public class Problem37 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	static boolean[] prime = Euler.primeArray(1000000);
	
	public static int solution() {
		int sum = 0;
		
		for (int i = 999999; i > 9; i-=2) {
			if (prime[i]) {
				if (isTruncatable(i)) {
					sum+=i;
				}
			}
		}
		return sum;
	}

	private static boolean isTruncatable(int i) {
		int kuttet = i;
		while ((kuttet = kuttet/10) != 0) {
			if (!prime[kuttet])
				return false;
		}
		
		int tier = 1;
		while ((tier*=10) < i) {
			if (!prime[i%tier])
				return false;
		}
		return true;
	}
}
