package problems;

import java.util.HashSet;
import java.util.Set;

import utils.Euler;

public class Problem216 {
	
	
//	private static int TARGET = 50000000;
//	private static ArrayList<Integer> list = Euler.primeList((int)(2*TARGET));
//	static int size = list.size();
//	static int teller = 0;
	
	
	public static void main(String[] args) {
//		int threads = 10;
//		for (int i = 0; i < threads; i++) {
//			new Problem216((TARGET/threads)*(i+1), (TARGET/threads)*i, ""+i);
//		}

		int limit = 1000000;
		Set<Long> set = new HashSet<Long>();
		for (long i = 2; i <= limit; ++i) {
			set.add(i);
		}
		
		int ant = 0;
		int i = 0;
		for (Integer prime : Euler.primeList(2*limit)) {
			if (++i % 10 == 0)
				System.out.println(prime + " " + set.size());
			if (prime != 2) {
				Set<Long> remove = new HashSet<Long>();
				for (Long integer : set) {
					if (prime > 2*integer) {
						remove.add(integer);
						++ant;
					} else if ((2*integer*integer-1)%prime == 0) {
						remove.add(integer);
					}
				}
				set.removeAll(remove);
			}
		}
		System.out.println(ant);
	}
	
//	public static boolean test(long n) {
//		if ((n+1)%6==0 || (n-1%6==0)
//			return true;
//		return false;
//	}
}


//27439531