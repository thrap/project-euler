package problems;

import utils.Euler;



public class Problem153 {
	static long start = System.currentTimeMillis();
	static int limit = 100000000;
	static boolean[] prime = Euler.primeArray((int)Math.sqrt(limit));
	
	public static void main(String[] args) {
		
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+" ms)");
	}
	
	public static long solution() {
		long sum = 0;
		
		int tempLimit = limit;
		for (int r = 1; r <= tempLimit; r++) {
			sum+=r*(limit/r);
		}
		
		
		
		for (long r = 1; r <= limit/2; r++) {
			sum+=2*r*(limit/(2*r)); //for r == i
		}
		
		for (long r = 1; r <= Math.sqrt(limit); r++) {
//			if (r%100 == 0) {
//				System.out.println(r);
//			}
//			
			for (long i = 1; i < r; i++) {
				if (gcd(r, i) != 1) 
					continue;
//				r*r - i*(-i)
				long ant;
				for (int j = 1; (ant=limit/(j*(r*r + i*i))) != 0; j++) {
					sum+=2*ant*j*(r + i); //2 = for pluss og minus, r+i = for aa unngaa dobbel loop til limit/2
				}
			}
		}
		return sum;
	}

	public static long gcd(long a, long b) {
		if (b == 0)
	       return a;
	    else {
	    	if (prime[(int)a])
				return b%a == 0?a:1;
			if (prime[(int)b])
				return a%b == 0?b:1;
	    	return gcd(b, a % b);
	    }
	}
}
