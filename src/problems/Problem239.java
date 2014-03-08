package problems;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import utils.Euler;

public class Problem239 {
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(100);
		BigInteger over = BigInteger.ONE;
		BigInteger under = BigInteger.valueOf(100*99*98);
		for (int i = 0; i < primes.size()-3; i++) {
			over = over.multiply(BigInteger.valueOf(96-i));
			under = under.multiply(BigInteger.valueOf(97-i));
		}
		System.out.println(over + " "+under);
		//fordi de etter er avhengige om de fr har tatt plassen eller ikke hmmmm
		
		System.out.println(new BigDecimal(over).divide(new BigDecimal(under), 200, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(2300)));
	}
	
	public static void reccursion(int primes, int primplasserTatt, BigInteger over, BigInteger under) {
		if (primes == 25) {
			//ferdig lizm
			return;
		}
		
	}
}
