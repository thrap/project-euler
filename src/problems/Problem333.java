package problems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.Euler;

public class Problem333 {
	
	static Map<Integer, Set<Integer>> map;
	static int[] ways;
	static int limit = 1000000;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		ways = new int[limit+1];
		
		Set<Integer> alletall = new TreeSet<Integer>();
		for (int i = 0; Math.pow(2, i) < limit; i++) {
			for (int j = 0; true; j++) {
				long tall = (long)Math.pow(2, i)*(long)Math.pow(3, j);
				if (tall > limit)
					break;
				alletall.add((int)tall);
			}
		}
		alletall.remove(1);
		
		map = new TreeMap<Integer, Set<Integer>>();
		for (Integer integer : alletall) {
			ways[integer]++;
			Set<Integer> set = new TreeSet<Integer>();
			for (Integer tall : alletall) {
				if (tall <= integer)
					continue;
				if (tall % integer != 0 && integer+tall <= limit)
					set.add(tall);
			}
			map.put(integer, set);
		}
		
		for (Integer integer : map.keySet()) {
			System.out.println(integer + ": " + map.get(integer));
		}
		
		int a = 0;
		for (Integer i : map.keySet()) {
			System.out.println(i + " " + ++a + "/"+map.keySet().size());
			Set<Integer> set1 = map.get(i);
			populateWays(i, new TreeSet<Integer>(set1));
		}
		
//		System.out.println(map);
		System.out.println(alletall);
		
		long sum = 0; 
		for (Integer integer : Euler.primeList(limit)) {
			if (ways[integer] == 1) {
				System.out.println(integer + ": "+ways[integer]);
				sum+=integer;
			}
		}
		System.out.println(sum + " ("+(System.currentTimeMillis()-start)+"ms)");
	}

	private static void populateWays(Integer i, Set<Integer> set1) {
		if (set1.isEmpty())
			return;
		for (Integer j : set1) {
			if (i+j > limit)
				break;
			ways[i+j]++;
			Set<Integer> set2 = new TreeSet<Integer>(map.get(j));
			set2.retainAll(set1);
			populateWays(i+j, set2);
		}
	}
}
