package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem122tregOgGay {
	public static void main(String[] args) {
		long sum = 1;
		for (int i = 3; i <= 200; i++) {
			System.out.println(i);
			sum+=m(i);
		}
		System.out.println(m(15));
		
		System.out.println(sum);
	}
	
	
	static Random r = new Random();
	
	public static int m(int k) {
		int m = Integer.MAX_VALUE;
		for (int i = 0; i < 1000000; i++) {
			m = randomM(k, m);
		}
		return m;
	}
	
	public static int randomM(int k, int max) {
		List<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		
		while(true) {
			Collections.shuffle(set);
			int a;
			if (r.nextBoolean()) {
				a = set.get(0) + set.get(1);
			} else {
				a = set.get(0)*2;
			}
			if (set.size() == max)
				return max;
			if (a == k) {
				return set.size();
			}
			if (a < k && !set.contains(a)) {
				set.add(a);
			}
			int diff = k-a;
			if (set.contains(diff))
				return Math.min(max, set.size());
			if (diff%2==0 && set.contains(diff/2))
				return Math.min(max,set.size()+1);
		}
	}
}
