import java.math.BigInteger;
import static java.math.BigInteger.*;


public class Problem401 {
	public static void main(String[] args) {
		long n = (long) Math.pow(10,15);
		BigInteger N = valueOf(n);
		BigInteger sum = ZERO;
		long sum2 = 0;
		long mod = (long) Math.pow(10, 9);
		long limit1 = (long) Math.pow(10,8);
		for (long k = 1L; k <= limit1; k++) {
			if (k % (limit1/100) == 0) {
				System.out.println(k/(limit1/100) + " / " + 100);
			}
			sum2 += (k*k*(n/k))%mod;
			sum2 %= mod;
			BigInteger K = valueOf(k);
			sum = sum.add(K.multiply(K).multiply(N.divide(K)));
		}
		System.out.println(sum2);
		System.out.println(sum.mod(TEN.pow(9)));
		
		BigInteger SIX = valueOf(6);
		BigInteger TWO = valueOf(2);
		for (long quotient = n/limit1; quotient >= 2; quotient--) {
			if (quotient % 100000 == 0) {
				System.out.println(quotient);
			}
			long a = n/quotient + 1;
			long b = n/(quotient-1);
			BigInteger A = valueOf(a);
			BigInteger B = valueOf(b);
			sum2 += (quotient-1)*((1-a+b)*(2*b*b-a+2*a*a+b+2*a*b))/6;
			sum2 %= mod;
			sum = sum.add(valueOf(quotient-1).multiply(ONE.subtract(A).add(B).multiply(TWO.multiply(B).multiply(B).subtract(A).add(TWO.multiply(A).multiply(A)).add(B).add(TWO.multiply(A).multiply(B))).divide(SIX)));
			//1/6 (1-a+b) (2 b^2-a+2 a^2+b+2 a b)
		}
		System.out.println(sum2);
		System.out.println(sum.mod(TEN.pow(9)));
		
	}
}
