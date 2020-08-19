import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem233 {
	
	static long[] superPrimes;
	static Set<Integer> skumlinger = new HashSet<Integer>();
	static long LIMIT = (long)Math.pow(10,11);
	static Set<Long> fourTwoZero = new TreeSet<Long>();
	
	static {
		int PRIME_LIMIT = (int)((long)(Math.pow(10, 11))/(5*5*5*13*13));
		
		for (Integer prime : Euler.primeList(PRIME_LIMIT)) {
			if ((prime-1)%4 == 0) {
				skumlinger.add(prime);
			}
		}
		
		superPrimes = new long[skumlinger.size()];
		int i = 0;
		for (int p : skumlinger) {
			superPrimes[i++] = p;
		}
		Arrays.sort(superPrimes);
	}
	
	public static void main(String[] args) {
		
		T t = new T();

		add(1,2,3);
		add(1,3,2);
		add(2,1,3);
		add(2,3,1);
		add(3,1,2);
		add(3,2,1);
		add(2,10);
		add(10,2);
		add(3,7);
		add(7,3);
		
		List<Integer> dontSkip = new ArrayList<Integer>(); 
		long lowest = fourTwoZero.iterator().next();
		ytterste:
		for (int i = 1; i*lowest <= LIMIT; i++) {
			for (int p : Euler.primeFactorDistinctList(i)) {
				if (skumlinger.contains(p)) {
					continue ytterste;
				}
			}
			dontSkip.add(i);
		}
		
		long sum = 0;
		for (long long1 : fourTwoZero) {
			for (int i : dontSkip) {
				if (i*long1 > LIMIT)
					break;
				sum += i*long1;
			}
		}
		
		System.out.println(sum + " " + t);
	}

	private static void add(int a, int b) {
		long A = 1;
		for (int i = 0; i < superPrimes.length && Math.pow(A, a+b) <= LIMIT; i++) {
			A = superPrimes[i];
			long Apow = (long)Math.pow(A, a);
			long Bpow = 1;
			for (int j = i+1;  j < superPrimes.length && Apow*Bpow <= LIMIT; j++) {
				Bpow = (long)Math.pow(superPrimes[j], b);
				fourTwoZero.add(Apow*Bpow);
			}
		}
	}

	private static void add(int a, int b, int c) {
		long A = 1;
		for (int i = 0; i < superPrimes.length && Math.pow(A, a+b+c) <= LIMIT; i++) {
			A = superPrimes[i];
			long Apow = (long)Math.pow(A, a);
			long B = 1;
			for (int j = i+1;  j < superPrimes.length && Apow*(long)Math.pow(B, b+c) <= LIMIT; j++) {
				B = superPrimes[j];
				long Bpow = (long)Math.pow(B, b);
				long Cpow = 1;
				for (int k = j+1; k < superPrimes.length && Apow*Bpow*Cpow <= LIMIT; k++) {
					Cpow = (long)Math.pow(superPrimes[k], c);
					fourTwoZero.add(Apow*Bpow*Cpow);
				}
			}
		}
	}
}
