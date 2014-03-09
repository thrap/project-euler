package Java;

import java.math.BigInteger;

public class Problem57 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		//1-2
		//1-(5-2) = 2-5
		//1-(12-5) = 5-12
		//1-(5-12+2)
		BigInteger t = BigInteger.valueOf(1);
		BigInteger n = BigInteger.valueOf(2);
		
		int teller=0;
		for (int i = 1; i < 1000 ; i++) {
			t = t.add(n.multiply(BigInteger.valueOf(2)));
			BigInteger temp = t;
			t=n;
			n=temp;
			if (n.add(t).toString().length() > n.toString().length()) {
				teller++;
			}
		}
		return teller;
	}
}
