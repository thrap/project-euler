package problems;

import java.util.List;

import utils.Euler;

public class Problem134WTF_TRODDE_FERDIG {
	public static void main(String[] args) {
		
		List<Integer> primes = Euler.primeList(1000003);
		long sum = 0;
//		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 2; i < primes.size()-1; i++) {
			int p1 = primes.get(i);
			int p2 = primes.get(i+1);
			
			int tall = p2;
			int length = (int)Math.pow(10, (""+p1).length());
			tall%=length;
//			System.out.println(length);
			for (int s = 1;true; ++s) {
				if (tall == p1) {
					sum+=((long)(s)*(long)(p2));
//					sum = sum.add(BigInteger.valueOf(s).multiply(BigInteger.valueOf(p2)));
//					System.out.println(s*p2);
					break;
				}
				tall += p2;
				tall%=length;
			}
			if (i%500 == 0)
				System.out.println(i + " / " + primes.size());
		}
		System.out.println(sum);
		
		//18613759984617118
	}
}
