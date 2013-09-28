package problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utils.Euler;

public class Problem26 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start) + "ms)");
	}

	public static int solution() {
		int beste = 0;
		int primez = 0;
		BigDecimal d = BigDecimal.ONE;
		for (int prime : Euler.primeList(1000)) {
			String s = d.divide(BigDecimal.valueOf(prime),2000, RoundingMode.FLOOR).toString();
//			System.out.println(s);
			ytterste:
			for (int cycle = 1; cycle < 1000 ; ++cycle) {
				for (int i = 10; i < cycle+10; ++i) {
					if (s.charAt(i) != s.charAt(i+cycle)) {
						continue ytterste;
					}
				}
				if (cycle > beste) {
					beste = cycle;
					primez = prime;
				}
				break;
			}
		}
		return primez;
	}
}
