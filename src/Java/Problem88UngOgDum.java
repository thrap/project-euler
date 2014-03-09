package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Euler;

public class Problem88UngOgDum {
	public static void main(String[] args) {
		int limit = 120;
		int[] ks = new int[limit+1];
		Arrays.fill(ks, Integer.MAX_VALUE);
		for (int i = 2; i <= limit*4; i++) {
			for (int k : k(i)) {
				if (k == 10 && ks[k] > i) {
					System.out.println("++++++++++++++"+i);
				}
				if (k <= limit)
					ks[k] = Math.min(ks[k], i);
			}
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i <= limit; i++) {
			set.add(ks[i]);
			System.out.println(i + " " + ks[i]);
		}
		
		long sum = 0;
		for (Integer integer : set) {
			sum+=integer;
		}
		System.out.println(sum);
		
		System.out.println(k(16));
	}
	
	static Map<Integer, Set<Integer>> memo2 = new HashMap<Integer, Set<Integer>>();
	static Map<Integer, List<Integer>> memo = new HashMap<Integer, List<Integer>>();
	
	public static Set<Integer> k(int i) {
		Set<Integer> ks = new HashSet<Integer>();
		List<Integer> factors = memo.containsKey(i)?memo.get(i):Euler.primeFactorList(i);
		memo.put(i, factors);
		
		for (Integer integer : Euler.divisorList(i)) {
			int k = i - (integer+i/integer)+(2);
			ks.add(k);
		}
		
		for (int j = 0; j < Math.pow(2, factors.size()); j++) {
			String binaryString = Integer.toBinaryString(j);
			for (int k = binaryString.length(); k < factors.size(); k++) {
				binaryString = '0'+binaryString;
			}
			
			int sum = 0;
			int prod = 0;
			int tall = 0;
			for (int k = 0; k < binaryString.length(); k++) {
				if (binaryString.charAt(k) == '0') {
					sum+=factors.get(k);
				} else {
					++tall;
					if (prod == 0)
						prod = factors.get(k);
					else
						prod*=factors.get(k);
				}
			}
			if (tall == 1)
				continue;
			
			tall = binaryString.length()-tall + (tall==0?0:1);
//			
//			System.out.println(binaryString);
//			System.out.println("tall = "+tall);
//			System.out.println("prod = "+prod + "\nsum = " + sum);
			int k = i - (sum+prod)+(tall);
//			System.out.println("k = " + k);
			ks.add(k);
		}
		
		return ks;
	}
}
