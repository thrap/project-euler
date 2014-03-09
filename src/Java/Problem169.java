package Java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class Problem169 {
	
	static Map<BigInteger, Long> map = new HashMap<BigInteger, Long>();
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		
		//f(2k+1) = f(k), f(2k) = f(k)+ f(k-1)
		BigInteger tall = BigInteger.valueOf(10);
		tall = tall.pow(25);
		return count(tall);
	}

	public static long count(BigInteger tall) {
		BigInteger siste = tall.mod(BigInteger.valueOf(2));
		BigInteger rest = tall.divide(BigInteger.valueOf(2));
		
		if (rest.equals(BigInteger.valueOf(0)))
			return 1;

		if (map.containsKey(tall)) { 
			return map.get(tall);
		}
		
		if (siste.equals(BigInteger.valueOf(1))) {
			long ant = count(rest);
			map.put(tall, ant);
			return ant;
		} else {
			long ant = count(rest) + count(rest.subtract(BigInteger.valueOf(1)));
			map.put(tall, ant);
			return ant;
		}
	}
}
