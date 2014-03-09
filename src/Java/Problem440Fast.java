package Java;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import utils.Euler;
import utils.T;

public class Problem440Fast {
	public static void main(String[] args) {
		T t = new T();
		int i = 2000;
		System.out.println("S("+i+") = "+S(i) + " " + t);
	}

	static long mod = 987898789;
	private static long S(int L) {
		long sum = 0;
		
		// c == 1
		sum += 10*L*L;
		
		for (int c = L; c >= 2; c--) {
			System.out.println(c + " / " + L + " (2)");
			
			// a%2 != b%2
			for (int a = 1; a <= L; a++) {
				for (int b = a+1; b <= L; b+=2) {
					sum += 2*T((c%2 == 0 ? 0 : 1));
					sum %= mod;
				}
			}
			
			BigInteger C = valueOf(c);
			for (int a = 1; a <= L; a+=2) {
				for (int b = a+2; b <= L; b+=2) {
					sum += 2*T(C.pow(Euler.gcd(a, b)));
					sum %= mod;
				}
			}
			
			for (int a = 2; a <= L; a+=2) {
				for (int b = a+2; b <= L; b+=2) {
					int gcd = Euler.gcd(a, b);
					
					if ((b-gcd)%(2*gcd) == 0 && (a-gcd)%(2*gcd) == 0) {
						sum += 2*T(C.pow(gcd));
						sum %= mod;
						continue;
					} else {
						sum += 2*T((c%2 == 0 ? 0 : 1));
						sum %= mod;
						continue;
					}
				}
			}
		}
		
		System.out.println(sum);
		// a and b equal
		for (int c = L; c >= 2; c--) {
			memoize.clear();
			BigInteger C = valueOf(c);
			BigInteger cpow = ONE;
			System.out.println(c + " / " + L + " (1)");
			for (int ab = 1; ab <= L; ab++) {
				cpow = cpow.multiply(C);
				sum+= T(cpow);
				sum %= mod;
			}
		}
		return sum;
	}
	//454105469
	static Map<Long, Long> memoize = new HashMap<Long, Long>();
	private static long T(long n) {
		if (n == 0)
			return 1;
		if (memoize.containsKey(n))
			return memoize.get(n);
		long T = Euler.matrixPow(new long[][] {{10,1}, {1,0}},n, mod)[0][0];
		memoize.put(n, T);
		return T;
	}

	private static long T(BigInteger n) {
		if (n.compareTo(BigInteger.valueOf(mod)) == 1)
			return T(n.mod(valueOf(mod)).add(n.divide(valueOf(mod))));
		else return T(n.longValue());
//		if (n.equals(ZERO))
//			return 1;
//		return Euler.matrixPow(new long[][] {{10,1}, {1,0}},n, mod)[0][0];
	}
}
