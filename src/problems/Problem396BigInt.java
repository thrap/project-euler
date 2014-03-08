package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.*;

public class Problem396BigInt {
	/**
	 * se hva som skjer paa n = 8
	 * 
	 * virker som frste tall ikke har en dritt og si, bare teller ned sakte men sikkert
	 * og andre tall teller ned like hver gang frste gr til 0
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		BigInteger sum = ZERO;
		for (int n = 1; n <= 8; n++) {
			BigInteger g = valueOf(n);
			BigInteger k;
			BigInteger forrigeDiff = ZERO;
			BigInteger diff = valueOf(-2);
			BigInteger forrige;
			BigInteger delta = ZERO;
			int count = 0;
			int print = 0;
			BigInteger lastBig = ZERO;
			for (k = valueOf(2); !g.equals(ZERO); k = k.add(ONE)) {
				forrigeDiff = diff;
				forrige = g;
				
				
				List<BigInteger> list = new ArrayList<BigInteger>();
				while(!g.equals(ZERO)) {
					list.add(g.mod(k));
					g = g.divide(k);
				}
				for (int i = 0; i < list.size(); i++) {
					g = g.add(list.get(i).multiply(k.add(ONE).pow(i)));
				}
				g = g.subtract(ONE);

				diff = g.subtract(forrige);
				if (delta.equals(diff.subtract(forrigeDiff))) {
					count++;
				} else {
					count = 0;
				}
				if (count >= 3) {
					BigInteger ant = list.get(0).subtract(ONE);
					k = k.add(ant);
					g = g.add(diff.multiply(ant).add(delta.multiply(ant.multiply(ant.add(ONE)).divide(valueOf(2)))));
					count = 0;
				}
				delta = diff.subtract(forrigeDiff);

				System.out.println(list + " "+g);
				System.out.println("Delta: " + delta);
				System.out.println(diff);
				if (list.size() >= 3 && n == 8 && list.get(2).equals(ONE)) {
					//(24)(24+1)/2+(24*2^1)(24*2^1+1)/2+24*2*2+...
					//24(1+2+3+4+...) = 24*(2*3 )/2
					if (list.get(1).equals(valueOf(0)))
						System.exit(0);
				}
				if (list.get(0).equals(ZERO) && ++print % 10000 == 0) {
					System.out.println(k.toString().length() + " "+ list);
					System.out.println(delta);
					lastBig = g;
				}
//				if (k.compareTo(valueOf(1000000000).pow(100)) == 1) {
//					System.out.println(g);
//					System.out.println(158329712148476L);
//					System.out.println(k);
//					System.out.println(k + " (" + (System.currentTimeMillis()-start)+"ms)");
//					System.exit(0);
//				}
			}
			sum = sum.add(k.subtract(valueOf(2)));
			System.out.println(n + ": "+ k.subtract(valueOf(2)));
		}
		System.out.println(sum);
	}
}
