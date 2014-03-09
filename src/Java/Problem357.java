package Java;

public class Problem357 {
	private static final boolean[] primtall = Test.primtallUnder(200000000);
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	
	public static long solution() {
		int teller = 0;
		long sum = Long.valueOf("1736324834183");
		for (int i = 99922762+1; i <= 100000000; i++) {
			if (divisors(i)) {
				sum+=i;
				teller++;
				if (teller%100 == 0)
					System.out.println(i + ": " + sum);
			}
		}
//		System.out.println(sum);
		return sum;
	}


	public static boolean divisors(int n) {
	    int limit = n;

	    for (int i = 1; i < limit; ++i) {
	    	if (n % i == 0) {
	    		int d1 = i;
	    		int d2 = n/i;
	    		//such that for every divisor d of n, d+n/d is prime.
	    		if (!(primtall[(d1+n/d1)] && primtall[(d2+n/d2)])) {
//	    			System.out.println((d1+n/d1) + " eller " + (d2+n/d2) + " er ikke primtall");
	    			return false;
	    		}
//	    		System.out.println(n/i + " " + i);
	            limit = n / i;
	        }
	    }

	    return true;
	}
}
