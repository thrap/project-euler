package problems;

import java.math.BigInteger;

import utils.Euler;

public class Problem129 {
	
	public static BigInteger R(int k) {
		return BigInteger.valueOf(10).pow(k).divide(BigInteger.valueOf(9));
	}
	
	public static int A(int n) {
		for (int p = 2; true; p++) {
			if (R(p).mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO))
				return p;
		}
	}
	
	public static int bedreA(int n) {
		for (int p = 2; true; p++) {
			if (divides(p,n))
				return p;
		}
	}

	
	public static boolean divides(long n, int p) {
		return BigInteger.valueOf(10).modPow(BigInteger.valueOf(n), BigInteger.valueOf(p*9)).intValue() == 1;
	}
	
	
	public static void main(String[] args) throws Exception {
		//om n er delelig på a er R(n) delelig på R(a) 
		System.out.println(solution());
		/**
		 * FACT: R(k) er delelig på k-1 om gcd(k,10)==1
		 * 
		 * ER k PRIME GIR A(k) max i-1
		 * 
		 * fact1: er i primtall, er A(i) lik i-1
		 * nai stememr ikke lol
		 * 
		 * fact2: p can only divide Rn for prime n if p = 2kn + 1 for some k.
		 * 
		 * 61 går, 67 går ikke, 69 går, 71 går ikke
		 * 
		 * om det finnes et tall under i-1 som gir 
		 */
//		System.out.println(A(41));
//		System.out.println(A(7));
//		int biggest = 0;
//		for (int i = 2; true; i++) {
//			if (i%2 != 0 && i%5 != 0) {
//				int a = A(i);
//				if (a >= i-1)
//					System.out.print("OMG: ");
//				System.out.print("A("+i+") = "+ a);
//				if (Euler.isPrime(i) && a != i-1 && i != 3){
//					System.out.print(" TEORI FEILET: "+ i + " er prime");
//					
//				} else if (Euler.isPrime(i))
//					System.out.print(" STEMMER");
//				if (a > biggest) {
//					biggest = a;
//					if (!Euler.isPrime(i)) {
//						System.out.print(" VAR IKKE PRIME");
//					} else if (a != i-1 && i != 3){
//						System.out.print("TEORI FEILET");
//						System.exit(0);
//					}
//				}
//				System.out.println();
//			}
//		}
		
//		for (int prime : Euler.primeList(1000093)) {
//			if (prime-1 > 1000000)
//				System.out.println(prime);
//		}
	}

	public static long solution() {
		long biggest = 0;
//		System.out.println(bedreA(7));
		//p divides R(n) if 10^n = 1 (mod 9p)
		for (int i = 1000000; true; i++) {
			if (Euler.gcd(i, 10) == 1) {
				long a = bedreA(i);
				if (a > biggest) {
					biggest = a;
					if (a > 1000000) {
						return i;
					}
				}
			}
		}
	}
}
