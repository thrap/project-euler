package problems;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem203FF {
	public static void main(String[] args) {
		boolean[] primtall = Test.primtallUnder(50000000);
		HashMap<Long,Boolean> map = new HashMap<Long,Boolean>();
		long[][] a = new long[51][51];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					a[i][j] = 1;
				else 
					a[i][j] = Long.MAX_VALUE;
			}
		}
		
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j <= i; j++) {
				if (a[i][j] != 0)
					a[i][j] = a[i-1][j] + a[i-1][j-1];
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (!map.containsKey(a[i][j]))
					map.put(a[i][j],true);
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(map);
		System.out.println(map.size());
		
		int teller = 0;
		BigInteger sum = new BigInteger("0");
		for(long e: map.keySet()) {
			for (int i = 2; i < primtall.length; i++) {
				if (primtall[i]) {
					if (i*i > e || i*i < 0) {
						teller++;
						sum = sum.add(new BigInteger(""+e));
						break;
					}
					if (e % (i*i) == 0) {
//						System.out.println(e + " " + i*i);
						break;
					}
				}
			}
		}
		System.out.println(teller);
		System.out.println(sum);
	}
}
