import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem387 {
	
//	static boolean isprime(long n) {
//		int i;
//		if(n<2) return false;
//		if(n<4) return true;
//		if(!((n&1)==1)) return false;
//		for(i=3;(long)i*i<=n;i+=2) if(n%i==0) return false;
//		return true;
//	}
	
	static List<Integer> LIST = Euler.primeList(10000000);

	public static boolean isPrime(long number) {
		for (Integer i : LIST) {
			if (number % i == 0)
				return false;
			if (i > Math.sqrt(number))
				return true;
			
		}
		return true;
	}
	
	public static long sum(long tall) {
		String tallet = "" +tall;
		long sum = 0;
		for (int j = 0; j < tallet.length(); j++) {
			sum+=tallet.charAt(j)-'0';
		}
		return sum;
	}
	
	public static boolean harshad(long tall) {
		return (tall%sum(tall)==0);
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static BigInteger solution() {
		List<Long> list = new ArrayList<Long>();
		for (long i = 1; i <= 9; i++) {
			list.add(i);
		}
		
		//rofl hvofor faen foer den ikke med 181???
		BigInteger sum = BigInteger.valueOf(181);
		for (int siffer = 1; siffer <= 14-1; siffer++) {
			System.out.println(siffer + " " + sum);
			List<Long> newList = new ArrayList<Long>();
			for (Long tallet : list) {
				long tall = tallet*10;
				for (int i = 0; i <= 9; i++) {
					if (harshad(tall+i)) {
						newList.add(tall+i);
					} else if (isPrime(tall+i) && isPrime(((tall+i)/10)/sum((tall+i)/10))) {
						if (tall+i > 100)
							sum = sum.add(BigInteger.valueOf(tall+i));
					}
				}
			}
			list = newList;
		}
//		System.out.println(sum);
		return sum;
	}
}
