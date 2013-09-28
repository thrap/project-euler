package problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import utils.Euler;

public class Problem171v2 {
	
	public static long f(long n) {
		long sum = (n%10)*(n%10);
		while ((n /= 10)!=0) {
			sum+=(n%10)*(n%10);
		}
		return sum;
	}
	
	
	static Map<Long, Long> map = new HashMap<Long, Long>();
	
	public static void main(String[] args) {
		System.out.println(f(442));
		fillMap();
		fillString("", 0);
	}
	
	private static long fac(int i) {
		if (i == 0)
			return 1;
		long fac = 1;
		for (int j = 1; j <= i; j++) {
			fac*=j;
		}
		return fac;
	}
	
	private static long permutations(String a) {
		int[] count = new int[10];
		for (int i = 0; i < a.length(); i++) {
			count[a.charAt(i)-'0']++;
		}
		
		long result = fac(a.length());
		for (int i = 0; i < count.length; i++) {
			result/=fac(count[i]);
		}
		
		return result;
	}
	
	static long asd = 0;
	static long supersum = 0;
	private static void fillString(String a, int b) {
		if (a.length() == 11) {
			System.out.println(a);
			long sum = 0;
			for (int i = 0; i < a.length(); i++) {
				int c = a.charAt(i)-'0';
				sum+=c*c;
			}
			
			
			for (Long i : map.keySet()) {
				if (Euler.isPerfectSquare(i+sum)) {
					BigInteger asdsd = BigInteger.valueOf(permutations(a)).multiply(BigInteger.valueOf(map.get(i))).mod(BigInteger.valueOf(1000000000));
					supersum+= asdsd.longValue();
					supersum%=1000000000;
//					System.out.println(i + " " + sum);
				}
			}
			System.out.println(supersum);
			return;
		}
		
		for (int i = b; i <= 9; i++) {
			fillString(a+i, i);
		}
	}

	private static void fillMap() {
		for (int i = 1; i < 1000000000; i++) {
			if (i%1000000 == 0)
				System.out.println(i);
			
			long f = f(i);
			if (map.containsKey(f)) {
				map.put(f, map.get(f)+i);
			} else {
				map.put(f, (long)i);
			}
		}
		System.out.println(map);
	}
}
