package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem154 {
	static int exp = 200000;
	static int[] fivepows = new int[exp+1];
	static int[] twopows = new int[exp+1];
	public static void main(String[] args) {
		//(a+b+c)! / (a!*b!*c!)
		//a b c er eksponenter til x^a*y^b*z^c
		//a+b+c = 200000
		System.out.println(pows(200000,2));
		for (int i = 0; i <= 200000; i++) {
			fivepows[i] = pows(i,5);
			twopows[i] = pows(i,2);
		}
		long antall = 0;
		for (int a = 0; a <= exp; a++) {
			if (a % 1000 == 0)
				System.out.println(a + " " + antall);
			for (int b = a, c; b <= (c = exp-(b+a)); b++) {
				//OVER = EXP
				//hvor mange 5'ere blir borte? viktig
				int pow5 = fivepows[a]+fivepows[b]+fivepows[c];
				int pow2 = twopows[a]+twopows[b]+twopows[c];
				if (49998-pow5 >= 12 && 199994-pow2 >= 12) {
					antall += perms(a,b,c);
				}
//				System.out.println(perms(a,b,c));
				//om (a+b+c)!/(a!*b!*c!) er delelig paa 10^12 er det god staemning
//				System.out.println(faktor(a,b,c)+" x^"+a + " y^"+b+" z^"+c);
			}
		}
		System.out.println(antall);
	}
	
	static Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
	private static int pows(int n, int p) {
		int amount = 0;
		/**
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 * flaskehals
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		int pow = p;
		while (pow <= n) {
			amount+=n/pow;
			pow*=p;
		}
		return amount;
	}

	private static int perms(int a, int b, int c) {
		if(a == b) {
			if (b == c)
				return 1;
			else 
				return 3;
		} else if (a == c) {
			return 3;
		} else if (b == c){
			return 3;
		} else {
			return 6;
		}
	}

	private static int faktor(int a, int b, int c) {
		return factorial(a+b+c)/(factorial(a)*factorial(b)*factorial(c));
	}
	
	private static int factorial(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum*=i;
		}
		return sum;
	}
}
