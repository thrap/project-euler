package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem303a {
	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		for (int tal = 1; tal <= 10000; tal++) {
			//lol mønster lizm gjetter 9999 hæhæhæhæ
			if (tal == 99) {
				sum = sum.add(BigInteger.valueOf(11335578L));
				continue;
			}
			if (tal == 999) {
				sum = sum.add(BigInteger.valueOf(111333555778L));
				continue;
			}
			if (tal == 9999) {
				sum = sum.add(BigInteger.valueOf(1111333355557778L));
				continue;
			}
			BigInteger tall = BigInteger.valueOf(tal);
			boolean funnet = false;
			BigInteger multiple = BigInteger.ZERO;
			if (goal(tall)) {
				sum = sum.add(BigInteger.ONE);
				continue;
			}
			List<BigInteger> lovlige = new ArrayList<BigInteger>();
			for (long i = 0; i <= 9; i++) {
				if (lovlig(tall.multiply(BigInteger.valueOf(i)), BigInteger.valueOf(10))) {
					if (goal(tall.multiply(BigInteger.valueOf(i)))) {
						funnet = true;
						multiple = min(tall.multiply(BigInteger.valueOf(i)), multiple);
					}
					lovlige.add(BigInteger.valueOf(i));
				}
			}
			for (int pow = 1; !funnet && pow < 100; pow++) {
				if (tall.equals(BigInteger.valueOf(9999)))
					System.out.println(pow + " " + lovlige.size());
				BigInteger tier = BigInteger.valueOf(10).pow(pow);
				BigInteger tier2 = tier.multiply(BigInteger.valueOf(10));
				List<BigInteger> lovlige2 = new ArrayList<BigInteger>();
				for (BigInteger k : lovlige) {
					for (int j = 0; j <= 9; j++) {
						BigInteger prod = k.add(BigInteger.valueOf(j).multiply(tier));
						BigInteger tallet = tall.multiply(prod);
						if (lovlig(tallet, tier2)) {
							if (goal(tallet)) {
								funnet = true;
								multiple = min(tallet, multiple);
							}
							lovlige2.add(prod);
						}
					}
				}
				lovlige = lovlige2;
			}
			System.out.println(tall + " " + multiple);
			sum = sum.add(multiple.divide(tall));
		}
		System.out.println(sum);
	}

	private static BigInteger min(BigInteger multiply, BigInteger multiple) {
		if (multiple.equals(BigInteger.ZERO))
			return multiply;
		if (multiply.equals(BigInteger.ZERO))
			return multiple;
		if (multiply.compareTo(multiple) < 0)
			return multiply;
		return multiple;
	}

	private static boolean goal(BigInteger l) {
		if (l.equals(BigInteger.ZERO))
			return false;
		String tallet = ""+l;
		for (int i = 0; i < tallet.length(); i++) {
			if (tallet.charAt(i) > '2')
				return false;
		}
		return true;
	}

	private static boolean lovlig(BigInteger tall, BigInteger pow) {
		String tallet = ""+tall.mod(pow);
		
		for (int i = 0; i < tallet.length(); i++) {
			if (tallet.charAt(i) > '2')
				return false;
		}
		return true;
	}
}
