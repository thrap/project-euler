package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Euler;

import static java.lang.Math.*;

public class Problem358Test {
	public static void main(String[] args) {
//		System.out.println(isCyclic(193421));
//		System.out.println(isCyclic(1934211));
//		System.out.println(isCyclic(19342111));
//		System.out.println(isCyclic(193421111));
		List<Integer> cycles = Arrays.asList(new Integer[] {7, 17, 19, 23, 29, 47, 59, 61, 97, 109, 113, 131, 149, 167, 179, 181, 193, 223, 229, 233, 257, 263, 269, 313, 337, 367, 379, 383, 389, 419, 433, 461, 487, 491, 499, 503, 509, 541, 571, 577, 593, 619, 647, 659, 701, 709, 727, 743, 811, 821, 823, 857, 863, 887, 937, 941, 953, 971, 977, 983});
		List<Integer> cycleList = new ArrayList<Integer>();
		for (int p : Euler.primeList(1000)) {
			if (p <= 5)
				continue;
			if (isCyclic(p)) {
				cycleList.add(p);
			}
		}
		System.out.println(cycles);
		System.out.println(cycleList);
		
		System.out.println(dydx(PI/4));
		System.out.println(dydx(-PI/4));
		System.out.println(dydx(PI*3.0/4));
		System.out.println(dydx(-PI*3.0/4));
	}
	
	private static double dydx(double d) {
		return (2*cos(2*d)*sin(d)+sin(2*d)*cos(d))/(2*cos(2*d)*cos(d)-sin(2*d)*sin(d));
	}

	private static final int B = 100;
	
	private static boolean isCyclic(int p) {
		long t = 0;
		long r = 1;
		long n = 0;
		do {
			t = t+1;
			long x = r*B;
			long d = x/p;
			r = x % p;
			n = n*B + d;
		} while(r != 1);
		System.out.println(p + ": "+ t*2);
		return (t == p-1);
	}
	
}
