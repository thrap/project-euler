package Java;

import java.math.BigInteger;

public class Problem225 {
	
	static BigInteger a = BigInteger.valueOf(1);
	static BigInteger b = BigInteger.valueOf(1);
	static BigInteger c = BigInteger.valueOf(1);
	static BigInteger d = BigInteger.valueOf(1);
	
	public static void main(String[] args) {
		BigInteger[] list = new BigInteger[40000];
		for (int i = 0; i < list.length; i++) {
			list[i] = fibonacci();
//			System.out.println(list[i]);
		}
		int teller = 0;
		for (int j = 1; j < list.length; j++) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].mod(BigInteger.valueOf(j)).equals(BigInteger.valueOf(0)))
					break;
				if (i == list.length-1 && j%2 == 1)
					System.out.println(++teller + ": " + j);
				if (teller == 124) {
					System.out.println("Grattis");
					System.exit(0);
				}
			}
		}
		System.out.println();
	}
	
	public static BigInteger fibonacci() {
//		BigInteger c;
		d = a.add(b).add(c);

		a = b;
		b = c;
		c = d;
		return d;
	}
}
