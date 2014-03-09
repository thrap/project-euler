package Java;

import java.math.BigInteger;

public class Problem160bestlol {
	
	static int remove = 100000;
	public static void main(String[] args) {
		int limit = 100000000;
		System.out.println(algo1(limit));
		System.out.println(algo2(limit));
		System.out.println(algo3(limit));
	}
	
	public static long algo1(int limit) {
		long sum = 1;
		for (int i = 1; i < limit; i++) {
			if (i%5!=0)
				sum*=i;
			sum%=remove;
		}
		return sum;
	}
	
	public static long algo2(int limit) {
		long sum = 1;
		for (int i = 1; i < limit; i++) {
			if (i%5!=0)
				sum*=i%remove;
			sum%=remove;
		}
		return sum;
	}
	
	public static long algo3(int limit) {
		long sum = 1;
		for (int i = 0; i < remove; i++) {
			if (i%5!=0)
				sum*=i;
			sum%=remove;
		}
		int ant = limit/remove;
		
		return BigInteger.valueOf(sum).modPow(BigInteger.valueOf(ant), BigInteger.valueOf(remove)).longValue();
	}
}
