import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem234 {
	public static void main(String[] args) {
		System.out.println(solution());
//		System.out.println(settet);
//		sum = 0;
//		for (int n = 8; n <= 1000; n++) {
//			if (n%lps(n) == 0 ^ n%ups(n) == 0) {
////				System.out.println(n);
//				sum+=n;
//			}
//		}
//		System.out.println(sum);
	}
	
	public static long solution() {
		long sum = 0;
		List<Integer> list = Euler.primeList(1000000);
		Set<Long> settet = new TreeSet<Long>();
		for (int i = 0; i < list.size()-1; i++) {
			Set<Long> set = new TreeSet<Long>();
			long p1 = list.get(i);
			long p2 = list.get(i+1);
//			System.out.println(p1 + " " + p2);
			
			for (long j = p1*p1+p1; j < p2*p2; j+=p1) {
				set.add(j);
			}
			for (long j = p2*p2-p2; j > p1*p1; j-=p2) {
				if (set.contains(j))
					set.remove(j);
				else
					set.add(j);
			}
			settet.addAll(set);
		}
		for (Long integer : settet) {
			if (integer <= 999966663333L)
				sum+=integer;
		}
//		System.out.println(sum);
		return sum;
	}

	public static int lps(int n) {
		n = (int)Math.sqrt(n);
//		System.out.println(n);
		for (;!Euler.isPrime(n); n--);
		return n;
	}
	public static int ups(int n) {
		n = (int)Math.sqrt(n) + (Euler.isPerfectSquare(n)?0:1);
//		System.out.println(n);
		for (;!Euler.isPrime(n); n++);
		return n;
	}
}
