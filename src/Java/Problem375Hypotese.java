package Java;

import java.util.HashMap;
import java.util.Map;

import utils.T;

public class Problem375Hypotese {
	private static class Range {
		long a;
		long b;
		long minS;
		public Range(long a, long b, long minS) {
			this.a = a;
			this.b = b;
			this.minS = minS;
		}
		
		public boolean inRange(long x) {
			return a <= x && x <= b;
		}
		
		public String toString() {
			return "["+a + " - " + b + "] = " + minS;
		}
	}
	
	private static final int PERIOD = 6308948;
	static long[] S = new long[PERIOD];
	private static final int MIN_S = 3;
	
	static {
		S[0] = 25388651;
		for (int i = 1; i < S.length; i++) {
			S[i] = (S[i-1]*S[i-1]) % 50515093;
		}
	}
	
	static Map<Long, Map<Long, Range>> maps = new HashMap<Long, Map<Long, Range>>();
	public static void main(String[] args) {
		maps.put(100L, createRangeMap(100L));
		maps.put(1000L, createRangeMap(1000L));
		maps.put(10000L, createRangeMap(10000L));

		for (int j = 1; j <= 200; j++) {
			for (int i = 1; i <= j; i++) {
				if (A(i,j) != A(i,j,10000)) {
					System.out.println(i + " " + j);
					System.out.println(A(i, j));
					System.out.println(A(i, j, 10000));
					System.out.println();
				}
			}
		}
		T t = new T();
		System.out.println(M(100000) + " " + t);
//		System.out.println(A(2, 6, 2));
//		System.out.println(A(2,6));
		
	}
	
	private static long M(int N) {
		long sum = 0;
		
		/**
		 *  kan kanskje kutte ned den doble forlOEkka paa noe vis?
		 */
		for (int j = 1; j <= N; j++) {
			if (j % 100 == 0)
			System.out.println(j + " " + calls);
			for (int i = 1; i <= j; i++) {
				sum+=A(i, j, 10000);
			}
		}
		return sum;
	}
	
	private static long A(int i, int j) {
		calls++;
		long min = Long.MAX_VALUE;
		for (; i <= j; i++) {
			min = Math.min(min, S[i]);
		}
		return min;
	}

	static int calls = 0;
	private static long A(long i, long j, long length) {
		if (length == 10) {
			return A((int)i, (int)j);
		}
		if (length == 0 || i == j) {
			return S[(int)i];
		}
		long iStart = ((i-1)/length)*length + 1;
		long jStart = ((j-1)/length)*length + 1;
		
		if (iStart == jStart) {
			return A(i, j, length/10);
		}

		long min = Long.MAX_VALUE;
		for (int k = 1; iStart + k*length != jStart; k++) {
			min = Math.min(maps.get(length).get(iStart + k*length).minS, min);
		}
		
		min = Math.min(min, A(i, iStart+length-1, length/10));
		min = Math.min(min, A(jStart, j, length/10));
		
		return min;
	}

	private static Map<Long, Range> createRangeMap(long length) {
		Map<Long, Range> map = new HashMap<Long, Range>();
		long min = Long.MAX_VALUE;
		for (int i = 1; i < S.length; i++) {
			if (i % 100000 == 0)
				System.out.println(i + " / " +6308948);
			min = Math.min(min, S[i]);
			if (i % length == 0) {
				map.put(i-length+1, new Range(i-length+1, i, min));
				min = Long.MAX_VALUE;
			}
		}
		System.out.println("Ferdig");
		return map;
	}
}
