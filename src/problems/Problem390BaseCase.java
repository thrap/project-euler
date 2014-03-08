package problems;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.Euler;
import utils.T;

public class Problem390BaseCase {
	public static void main(String[] args) {
		//(c*c+b*b+c*c*b*b)/4 maa vaere perfect square
		T t = new T();
		long limit = (long) Math.pow(10, 6);
		long areaLimit = 4*limit*limit;
		System.out.println(areaLimit);
		long areaSum = 0;
		long max = 0;
		Map<Long, Set<Long>> tree = new TreeMap<Long, Set<Long>>();
		for (long b = 2; 2*b*b+b*b*b*b <= areaLimit; b+=2) {
			for (long c = b; c*c+b*b+c*c*b*b <= areaLimit; c+=2) {
				long inni = b*b+c*c+b*b*c*c;
				max = Math.max(max,  b*b+(c+2)*(c+2)+b*b*(c+2)*(c+2));
				if (inni % 4 == 0 && Euler.isPerfectSquare(inni/4)) {
					if (tree.containsKey(b)) {
						tree.get(b).add(c);
					} else {
						Set<Long> set = new TreeSet<Long>();
						set.add(c);
						tree.put(b, set);
					}
					System.out.println(b + " " + c);
					areaSum += Math.sqrt(inni/4);
				}
			}
		}
		for (long tall : tree.keySet()) {
			if (tree.get(tall).size() > 1) {
				System.out.println(tall + ": "+tree.get(tall));
				long forrige = 1;
				for(long num : tree.get(tall)) {
					System.out.println(num/forrige);
				}
			}
		}
		System.out.println(areaSum + " " + t);
		System.out.println(max);
		System.out.println(Long.MAX_VALUE);
	}
}
