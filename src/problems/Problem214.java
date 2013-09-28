package problems;

import utils.Euler;

public class Problem214 {
	public static void main(String[] args) {
		final int antall = 40000000;
		
		boolean[] primtall = Euler.primeArray(antall);
		int[] phi = new int[antall];
		for (int i = 2; i < antall; i++) {
			phi[i] = fi(i);
			if (i % 1000000 == 0)
				System.out.println(i);
		}
		long sum = 0;
		for (int i = 2; i < antall; i++) {
			int lol = phi[i];
//			System.out.println(lol);
			for (int j = 0; j < 25-2; j++) {
				lol = phi[lol];
//				System.out.print(lol + " ");
				
				if (j == 25-3 && lol == 1 && primtall[i])
					sum+=i;
				
			}
			
			if (i % 1000000 == 0)
				System.out.println(i);
			
		}
		System.out.println(sum);
	}

	public static int fi(int n) {
		int result = n;
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0)
				result -= result / i;
			while (n % i == 0)
				n /= i;
		}
		if (n > 1)
			result -= result / n;
		return result;
	}
}
