import static java.math.BigInteger.*;

import java.math.BigInteger;

import utils.T;

public class Problem288BaseCase {
	
	private static class S {
		long last = 290797;
		
		public BigInteger next() {
			BigInteger temp = valueOf(last);
			this.last = (last*last)%50515093;
			return temp;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(NF(valueOf(3),10000).mod(valueOf(3).pow(20)));
		System.out.println(624955285);
	}
	
	private static BigInteger NF(BigInteger p, int q) {
		T t = new T();
		BigInteger N = N(p,q);
		System.out.println("Ferdig med N "+t);
		t = new T();
//		System.out.println(N);
		BigInteger pows = pows(N, p);
		System.out.println("Ferdig med NF " + t);
//		System.out.println(pows);
		return pows;
	}
	
	private static BigInteger pows(BigInteger n, BigInteger p) {
		BigInteger amount = ZERO;
		BigInteger pow = p;
		while (pow.compareTo(n) <= 0) {
			amount = amount.add(n.divide(pow));
			pow = pow.multiply(p);
		}
		return amount;
	}
	
	private static BigInteger N(BigInteger p, int q) {
		S s = new S();
		BigInteger number = ZERO;
		for (int n = 0; n <= q; n++) {
			BigInteger t = s.next().mod(p);
			
			number = number.add(p.pow(n).multiply(t));
		}
		
		return number;
	}
}
