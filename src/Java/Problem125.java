package Java;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem125 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static BigInteger solution() {
		BigInteger sum = BigInteger.valueOf(0);
		HashMap map = new HashMap();
		for (int i = 1; true; i++) {
			long tall = i*i;
			if (tall >= 100000000)
				break;
			for (int j = i+1; true; j++) {
				tall += j*j;
				if (tall >= 100000000)
					break;
				if (palindrom(""+tall) && !map.containsKey(tall)) {
					map.put(tall, true);
//					System.out.println(tall);
					sum = sum.add(BigInteger.valueOf(tall));
				}
			}
		}
//		System.out.println(sum);
		return sum;
	}

	public static boolean palindrom(String a) {
		String b="";
		for (int i = a.length()-1; i > -1; i--) {
			b += a.charAt(i);
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				return false;
		}
		return true;
	}
}
