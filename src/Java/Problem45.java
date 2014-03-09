package Java;

import java.util.HashSet;
import java.util.Set;

public class Problem45 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		long limit = 2000000000L;
		Set<Long> triangle = new HashSet<Long>();
		long t;
		for (long i = 1; (t=(i*(i+1))/2) < limit; i++) {
			triangle.add(t);
		}
		Set<Long> triangleAndPenta = new HashSet<Long>();
		long p;
		for (long i = 1; (p=(i*(3*i-1))/2) < limit; i++) {
			if (triangle.contains(p))
				triangleAndPenta.add(p);
		}
		long h;
		for (long i = 2; (h=(i*(2*i-1))) < limit; i++) {
			if (triangleAndPenta.contains(h) && h!=40755)
				return h;
		}
		return 0;
	}
}
