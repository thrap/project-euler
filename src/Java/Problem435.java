package Java;

import java.math.BigInteger;

import utils.Euler;
import utils.T;
import static java.math.BigInteger.*;


public class Problem435 {
	
	private static long mod = 1307674368000L;
	public static void main(String[] args) {
		int x = 2;
		int k = 3;
		Euler.printMatrix(Euler.matrixPow(new long[][] {{x,x}, {x,0}},k,mod));
		// tallene i matrisen er:
		// [Fib(k+1)*x^k, Fib(k)  *x^k]
		// [Fib(k)*  x^k, Fib(k-1)*x^k]
		System.out.println("[" + Euler.fib(k+1)*Euler.pow(x, k) + ", "+ Euler.fib(k)*Euler.pow(x, k)+"]");
		System.out.println("[" + Euler.fib(k)*Euler.pow(x, k) + ", "+ Euler.fib(k-1)*Euler.pow(x, k)+"]");
		System.out.println();
		
		T t = new T();
		long n = (long)Math.pow(10, 15);
		long sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += F(i, n) % mod;
		}
		
		System.out.println(sum % mod + " " + t);
		
	}
	
	public static long F(long x, long n) {
		BigInteger a = valueOf(x).pow(2).multiply(valueOf(g(x,n))).add(valueOf(g(x, n+1))).subtract(valueOf(x));
		BigInteger b = valueOf(x).pow(2).add(valueOf(x)).subtract(ONE);
//		return (x*x*g(x, n)+g(x, n+1)-x) / (x*x+x-1);
		return a.divide(b).longValue() % mod;
	}
	
	public static long g(long x, long n) {
		return Euler.matrixPow(new long[][] {{x,x}, {x,0}},n,mod*(x*x+x-1))[1][0];
	}
}
