package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem396BaseCaseBigInt {
	public static void main(String[] args) {
		int sum = 0;
		for (int n = 1; n <= 8; n++) {
			BigInteger g = BigInteger.valueOf(n);
			int k;
			for (k = 2; !g.equals(BigInteger.ZERO); k++) {
				List<BigInteger> list = new ArrayList<BigInteger>();
				BigInteger base = BigInteger.valueOf(k);
				while(!g.equals(BigInteger.ZERO)) {
					list.add(g.mod(base));
					g = g.divide(base);
				}
				for (int i = 0; i < list.size(); i++) {
					g = g.add(list.get(i).multiply(base.add(BigInteger.ONE).pow(i)));
				}
				g=g.subtract(BigInteger.ONE);
				if (k % 10000 == 0)
					System.out.println(list + " "+g + " "+n);
			}
			sum+=(k-2);
			System.out.println(k - 2);
		}
		System.out.println(sum);
	}
}
