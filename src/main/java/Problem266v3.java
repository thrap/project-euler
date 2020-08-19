import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import utils.Euler;

public class Problem266v3 {
	static BigInteger PRIME[];
	static BigInteger GOAL = new BigInteger("2323218950681478446587180516177954548");
	static BigInteger BEST = BigInteger.ONE;
	
	static {
		List<Integer> primes = Euler.primeList(190);
		PRIME = new BigInteger[primes.size()];
		for (int i = 0; i < primes.size(); i++) {
			PRIME[i] = BigInteger.valueOf(primes.get(i));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(PRIME));
		
		recursion(0, BigInteger.ONE);
	}
	
	//TODO denne tar med 1 hele veien og det er jo grisegay som faen
	//beste fra denne = 2323218950032606126782205593224856300
	public static void recursion(int n, BigInteger product) {
		//LOL MED 4 TALL TAR DENNE DRITLANG TID OGSAA
		if (n == 4)
			return;
		if (product.compareTo(BEST) == 1) {
			BEST = product;
			System.out.println(BEST);
			System.out.println(GOAL);
		}
		for (int i = 1; true; i++) {
			BigInteger newProduct = product.multiply(PRIME[n].pow(i));
			if (n == 3) {
				System.out.println(newProduct);
				System.out.println(i);
			}
			if (newProduct.compareTo(GOAL) == 1)
				break;
			recursion(n+1, newProduct);
		}
	}
}
