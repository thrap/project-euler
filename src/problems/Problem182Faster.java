package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Euler;

public class Problem182Faster {
	public static void main(String[] args) {
		int p = 1009;
		int q = 3643;
		
		int n = p*q;
		int phi = (p-1)*(q-1);
//		int phi = Euler.fi(p*q);
		BigInteger N = BigInteger.valueOf(n);
		
		System.out.println(phi);
		int[] ms = {116575, 142077, 346086, 462662, 469947, 1194903, 1522773, 1540990, 1548275, 1664850, 1664851, 1806927, 1868860, 2010936, 2010937, 2127512, 2134797, 2153014, 2480884, 3205840, 3213125, 3329701, 3533710, 3559212, 3675786};

		// disse deler alle
		// 346086, 1664850, 1664851, 2010936, 2010937, 3329701, 3675786 
		Set<Integer> unconcealable = new HashSet<Integer>(Arrays.asList(346086, 1664850, 1664851, 2010936, 2010937, 3329701, 3675786));
		
		long sum = 0;
		int count = 0;
		List<BigInteger> candidates = new ArrayList<BigInteger>();
		for (int e = 2; e < phi; e++) {
			if (e % 100000 == 0) {
				System.out.println(e + " / "+phi);
				System.out.println(sum);
			}
			if (Euler.gcd(e, phi) == 1) {
				BigInteger bigE = BigInteger.valueOf(e);
				int unconcealed = 0;
				for (int m: ms) {
					if (BigInteger.valueOf(m).modPow(bigE, N).intValue() == m) {
						unconcealed++;
					}
				}
				if (unconcealed == 7) {
					sum+=e;
					candidates.add(BigInteger.valueOf(e));
				}
				if (unconcealed < 7) {
					System.out.println("FUCK");
					System.exit(0);
				}
			}
		}
		
		
//		reccurse2(n, N, 2, unconcealable, candidates);
		reccurse(n, N, unconcealable, candidates);
		
		System.out.println(candidates.size());
		System.out.println(sum + " " + count);
		System.out.println(961081377984L);
	}

	private static void reccurse2(int n, BigInteger N, int m, Set<Integer> unconcealable, List<BigInteger> candidates) {
		System.out.println("Tester: "+m);
		System.out.println("Lengde: " + candidates.size());
		List<BigInteger> newCandidates = new ArrayList<BigInteger>();
		if (unconcealable.contains(m)) {
			newCandidates = candidates;
		} else {
			BigInteger M = BigInteger.valueOf(m);
			for (BigInteger e : candidates) {
				if (M.modPow(e, N).intValue() != m) {
					newCandidates.add(e);
				}
			}
		}
		reccurse2(n, N, m+1, unconcealable, newCandidates);
	}

	private static void reccurse(int n, BigInteger N, Set<Integer> unconcealable, List<BigInteger> candidates) {
		System.out.println("Ny st¿rrlese: " + candidates.size());
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger bigInteger : candidates) {
			sum = sum.add(bigInteger);
		}
		System.out.println("Forel¿pig sum: " + sum);
		
		//han her er en drittsekk 6071
		List<BigInteger> skalSjekke = new ArrayList<BigInteger>();
		int limit = 200000;
		for (BigInteger e : candidates) {
			System.out.println(e);
			for (int m = 2; m < limit; m++) {
				if (unconcealable.contains(m))
					continue;
				BigInteger M = BigInteger.valueOf(m);
				if (M.modPow(e, N).intValue() == m) {
					skalSjekke.add(M);
					limit = n-1;
				}
			}
			if (skalSjekke.size() != 0)
				break;
		}
		
		if (skalSjekke.size() == 0) {
			System.out.println("SVAR FUNNET YEAH BITCH");
			System.exit(0);
		} else {
			System.out.println("Fant ut at " + skalSjekke.size() + " nummere er en faen");
			System.out.println(skalSjekke);
		}
		
		List<BigInteger> newCandidates = new ArrayList<BigInteger>();
		
		int count = 0;
		ytterste:
		for (BigInteger e : candidates) {
			count++;
			if (count % 1000 == 0) {
				System.out.println(count + " / " + candidates.size());
			}
			for (BigInteger M : skalSjekke) {
				if (M.modPow(e, N).intValue() == M.intValue()) {
					continue ytterste;
				}
			}
			newCandidates.add(e);
		}
		
		reccurse(n, N, unconcealable, newCandidates);
	}
}
