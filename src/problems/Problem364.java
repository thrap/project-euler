package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Euler;
import utils.T;

public class Problem364 {
	private static class Seating {
		private boolean[] taken;
		private List<Integer> idx = new ArrayList<Integer>();
		
		boolean onlyRemaining = false;
		
		public Seating(boolean[] taken) {
			this.taken = taken;
			
			addNoAdjacent();
			if (idx.isEmpty()) {
				addOneAdjacent();
			}
			if (idx.isEmpty()) {
				onlyRemaining = true;
				addRemaining();
			}
		}
		private void addRemaining() {
			for (int i = 1; i < taken.length-1; i++) {
				if (!taken[i])
					idx.add(i);
			}
		}
		private void addOneAdjacent() {
			if (!taken[0])
				idx.add(0);
			if (!taken[taken.length-1])
				idx.add(taken.length-1);
			for (int i = 1; i < taken.length-1; i++) {
				if (!taken[i] && (!taken[i-1] || !taken[i+1]))
					idx.add(i);
			}
		}
		private void addNoAdjacent() {
			if (!taken[0] && !taken[1])
				idx.add(0);
			if (!taken[taken.length-2] && !taken[taken.length-1])
				idx.add(taken.length-1);
			for (int i = 1; i < taken.length-1; i++) {
				if (!taken[i-1] && !taken[i] && !taken[i+1])
					idx.add(i);
			}
		}
		
		public List<Seating> getChildren() {
			List<Seating> children = new ArrayList<Seating>();
			for (int i : idx) {
				boolean[] taken = this.taken.clone();
				taken[i] = true;
				children.add(new Seating(taken));
			}
			return children;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (boolean isTaken : this.taken) {
				sb.append((isTaken ? 'X' : '_'));
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		for (int i = 2; i < 24; i++) {
			long T = T(i);
			System.out.println(map);
			System.out.println("T("+i+") = " + T);
			System.out.println(Euler.primeFactorLongList(T));
			System.out.println();
			map.clear();
		}
		System.out.println(t);
	}
	
	private static long T(int N) {
		return reccurse(new Seating(new boolean[N]));
	}

	static int count = 0;

	static Map<String, Long> memoize = new HashMap<String, Long>();
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private static long reccurse(Seating seating) {
		String memo = seating.toString();
		if (memoize.containsKey(memo)) {
			return memoize.get(memo);
		}
		List<Seating> children = seating.getChildren();
		if (children.isEmpty()) {
			return 1;
		}
		long sum = 0;
		for (Seating child : children) {
			sum += reccurse(child);
		}
		memoize.put(memo, sum);
		return sum;
	}
}
