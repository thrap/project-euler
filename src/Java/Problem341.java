package Java;

import java.util.HashMap;
import java.util.Map;

public class Problem341 {
	public static void main(String[] args) {
		for (int i = 1; i < 1000000; i++) {
			G(i);
			System.out.println(i);
		}
		System.out.println(G(1000000));
	}
	
	static Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
	
	private static int G(int n) {
		if (n == 1) 
			return 1;
		if (memoize.containsKey(n))
			return memoize.get(n);
		int memo = 1+G(n - G(G(n-1)));
		memoize.put(n, memo);
		return memo;
	}
}
