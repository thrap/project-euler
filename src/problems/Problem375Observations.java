package problems;

import java.util.Random;

import utils.T;

public class Problem375Observations {
	
	public static void main(String[] args) {
		/**
		 * S(n) for n=1,2,.. er periodisk med periode 6308948
		 * Definerer S(0) = 25388651 gir hele S periodisk
		 * 
		 * SE P ABedre for mye mer effektiv A-funksjon for h¿ye tall
		 * 
		 * 
		 * 
		 * TODO: finne lokale bunnpunkter i S og utnytte dette litt pŒ samme mŒte som ABedre
		 * 
		 * TODO: Se static-initializen. lage noe slags rangeobjekt 
		 * 
		 * 
		 * lagre unna noen ranges -> s¿k etter S -> log(n % PERIOD) kj¿retid (ish) 
		 */
		
		T t = new T();
		
		System.out.println(ABedre(6308947843298748932L, 9108947843298748932L) + " " + t);
		System.out.println(ABedre(6308947843298748932L, 6308947843299798932L) + " " + t);
		
		System.out.println(M(10) + " " + t);
		System.out.println(M(100) + " " + t);
		System.out.println(M(1000) + " " + t);
	}

	private static long M(int N) {
		long sum = 0;
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= j; i++) {
				sum+=ABedre(i, j);
			}
		}
		return sum;
	}
	
	private static final int PERIOD = 6308948;
	static long[] S = new long[PERIOD];
	private static final int MIN_S = 3;
	
	static {
		int count = 0;
		S[0] = 25388651;
		long lastMin = Integer.MAX_VALUE;
		int lastStart = -1;
		int start = -1;
		for (int i = 1; i < S.length; i++) {
			S[i] = (S[i-1]*S[i-1]) % 50515093;
			if (S[i] < 100) {
				count++;
				if (lastMin != Integer.MAX_VALUE) {
					System.out.println("["+(lastStart+1) + " - " + (i-1) + "] = " + lastMin);
				}
				lastMin = S[i];
				lastStart = start;
				start = i;
				System.out.println(i + ": "+S[i]);
			}
		}
		System.out.println("Antall under 1000: "+count);
	}

	private static long ABedre(long i, long j) {
		if (i + PERIOD <= j) {
			return MIN_S;
		} else if ((i % PERIOD) > (j % PERIOD)) {
			return Math.min(ABedre(i % PERIOD, PERIOD), ABedre(0, j % PERIOD));
		} else if (j > PERIOD) {
			return ABedre(i % PERIOD, j % PERIOD);
		}
		
		long min = Long.MAX_VALUE;
		for (int k = (int)i; k <= j; k++) {
			min = Math.min(min, S[k]);
		}
		return min;
	}
	
	private static long A(int i, int j) {
		if (j == 0)
			return 25388651;
		long min = Long.MAX_VALUE;
		long S = 25388651;
		for (int k = 1; k <= j; k++) {
			S = (S*S) % 50515093;
			if (k >= i)
				min = Math.min(min, S);
		}
		return min;
	}
}
