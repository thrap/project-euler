package problems;

import java.util.HashMap;
import java.util.Map;

import utils.BigRational;

public class Problem152 {
	public static void main(String[] args) {
		BigRational r = new BigRational();
//		for (int i = 2; i <= 80; i++) {
//			r = r.add(new BigRational(1, i*i));
//			System.out.println(r);
//		}
//		System.out.println(r);
		recursion(r, 2);
		
		//TODO lol dette er bare moekka. maa finne smartere sjekk for too large og too small
	}
	
	static int i = 0;
	public static void recursion(BigRational r, int n) {
		if (n == numbers) {
			if (r.equals(goal))
				System.out.println(r);
			if (++i%10000 == 0)
				System.out.println(i + " " + r);
			return;
		} 
		if (!tooLarge(r)) {
			recursion(r.add(new BigRational(1, n*n)), n+1);
		}
		if (!tooSmall(r, n)) {
			recursion(r, n+1);
		}
	}
	
	static int numbers = 35;
	
	static Map<Integer, BigRational> MAX = new HashMap<Integer, BigRational>();
	
	static {
		BigRational r = new BigRational();
		for (int i = numbers; i >= 2; i--) {
			r = r.add(new BigRational(1, i*i));
			MAX.put(i+1, r);
//			System.out.println(r);
		}
	}
	
	private static boolean tooSmall(BigRational r, int n) {
		return r.add(MAX.get(n+1)).compareTo(goal) == -1;
	}

	static BigRational goal = new BigRational(1,2);
	
	private static boolean tooLarge(BigRational r) {
		return r.compareTo(goal) == 1;
	}
}
