package Java;

import utils.BigRational;
import utils.Euler;

public class Problem329 {
	private static boolean[] prime = Euler.primeArray(500);
	private static char[] string = "PPPPNNPPPNPPNPN".toCharArray();
	public static void main(String[] args) {
		for (int i = 1; i <= 500; i++) {
			reccursion(i,1,500,0);
		}
//		System.out.println(OVER + " / " + UNDER);
//		System.out.println(Euler.gcd(OVER, UNDER));
//		System.out.println(new Rational(OVER, UNDER));
//		System.out.println((double)OVER/UNDER);
		System.out.println(r);
//		System.out.println(r.toString().length());
	}
	
	static long OVER = 0;
	static long UNDER = 0;
	static BigRational r = new BigRational(0,1);
	static int teller = 0;
	private static void reccursion(int square, long over, long under, int number) {
		under = under*3;
		if (match(square,number)) {
			over = over*2;
		}
		if (number == string.length-1) {
			if (++teller % 100000 == 0)
				System.out.println(square + " " + over+"/"+under);
			OVER+=over;
			UNDER+=under;
			r = r.add(new BigRational(over, under));
			return;
		}
		if(square == 1) {
			reccursion(2, over, under, number+1);
		} else if (square == 500) {
			reccursion(499, over, under, number+1);
		} else {
			reccursion(square-1, over, under*2, number+1);
			reccursion(square+1, over, under*2, number+1);
		}
	}

	private static boolean match(int square, int i) {
		if (prime[square]) {
			return string[i] == 'P';
		} else {
			return string[i] == 'N';
		}
	}
}
