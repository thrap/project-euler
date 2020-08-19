import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem346 {
	
	public static BigInteger R(int b, int n) {
		return BigInteger.valueOf(b).pow(n).subtract(BigInteger.ONE).divide(BigInteger.valueOf(b-1));
	}
	
	
	public static void main(String[] args) {
		System.out.println(solution());
	}


	public static long solution() {
		long limit = 1000000000000L;
		
		Set<Long> set = new HashSet<Long>();
		ytterste:
		for (int b = 2; b < limit; b++) {
//			if (b%1000 == 0)
//				System.out.println(b);
			for (int n = 3; true; n++) {
				long tall = R(b,n).longValue();
				if (tall > limit) {
					if (n == 3)
						break ytterste;
					break;
				}
				set.add(tall);
			}
		}
		long sum = 1;
		for (Long tall: set) {
			sum+=tall;
			if (tall<0)
				System.out.println("aiai");
		}
//		System.out.println(sum);
		return sum;
	}
}
