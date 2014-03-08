package problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import utils.Euler;

public class Problem110NESTEN_FERDIG {
	public static void main(String[] args) {
//		113 = 
//		(2*1+1)*(2*3+1)
//		2^2x3^2x5^1x7^1 = (2*2+1)*(2*2+1)*(2*1+1)*(2*1+1)
//		System.out.println((2*2+1)*(2*2+1));
//		2*3*4*5*6*7*8*9*...

		/**
		 * 
		 * Antall losninger = (antDivisorer(tall^2)-1)/2
		 * 
		 */
//		antall 
		
		HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		
		int biggest = 3;
		BigInteger minste = null;
		map1.put(2, 1);
		map1.put(3, 1);
		
		boolean asd = false;
		for (int i = 2; true; ++i) {
			HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) map1.clone();
			List<Integer> list = Euler.primeFactorList(i);
			for (Integer integer : list) {
				if (integer > biggest) {
					biggest = integer;
					i = 2;
					System.out.println(integer);
					System.out.println(minste);
					map1.put(integer, 1);
					continue;
				}
				map.put(integer, map.get(integer)+1);
			}
			int max = 1;
			for (Integer in : map.keySet()) {
				max*=(map.get(in)*2+1);
//				System.out.println(in + ": " + map.get(in));
			}
			max = (max-1)/2;
			if (max > 4000000) {
				BigInteger tallet = BigInteger.valueOf(1);
				for (Integer integer : map.keySet()) {
					tallet = tallet.multiply(BigInteger.valueOf(integer).pow(map.get(integer)));
//					tallet*=Math.pow(integer, map.get(integer));
				}
//				if (tallet < minste) {
				if (minste == null || tallet.compareTo(minste) == -1) {
					minste = tallet;
					System.out.println(tallet);
				}
				asd = true;
			}
		}
		
	}
}
