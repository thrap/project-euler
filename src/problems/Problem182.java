package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem182 {
	public static void main(String[] args) {
		int p = 1009;
		int q = 3643;
		
		int n = p*q;
		int phi = (p-1)*(q-1);
		BigInteger bigN = BigInteger.valueOf(n);
		
		int min = Integer.MAX_VALUE;
		System.out.println(phi);
		for (int e = 2; e < phi; e++) {
			if (Euler.gcd(e, phi) == 1) {
				BigInteger bigE = BigInteger.valueOf(e);
				int d = modInv(e,phi);
				int unconcealed = 0;
				
				List<Integer> ms = new ArrayList<Integer>();
				for (int m = 0; m < n; m++) {
					if (BigInteger.valueOf(m).modPow(bigE, bigN).intValue() == m) {
						unconcealed++;
						ms.add(m);
						if (min < unconcealed)
							break;
					} 
				}
				min = Math.min(unconcealed, min);
				if (unconcealed == min) {
					System.out.println(Euler.primeFactorList(e));
					System.out.println(e + ": "+unconcealed + " " + ms);
				}
			}
		}
		
		
		System.out.println(n + " " + phi);
	}
	
public static int modInv(int value, int n) {
		int b0 = value;
		int n0 = n;
		int t0 = 0;
		int t = 1;
		int q = n / b0;
		int r = n0 - (q*b0);
		
		while (r > 0) {
			
			int temp = t0 - (q*t);

			if (temp > 0)
			  temp = temp % (n);
			if (temp < 0)
			  temp = n - (-temp % n);
			
			t0 = t;
			t = temp;
			n0 = b0;
			b0 = r;
			q = n0 / b0;
			r = n0 - (q * b0);
		}
		
		if (b0 != 1)
			return -1;
		else
		 	return t % n;
	}
}
