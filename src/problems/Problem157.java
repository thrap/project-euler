package problems;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem157 {
	public static void main(String[] args) {
		//10^n*(a+b) = p*b*a
		//p = 2^n*5^n(a+b)/(b*a)
		
		//n=1 med min metode (lol omg):
		//a=1, b=1
		//a=1, b=2
		//a=1, b=5
		//a=1, b=10
		//a=2, b=5
		
		//på n=1 er a=20 b=20 en gyldig løsning
		//på n=2 er a=200 b=200 en gyldig løsning, loop nedover på a'er her?
		int limit = 100000;
		Set<String> set = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] s1 = o1.split(" ");	
				String[] s2 = o2.split(" ");
				Integer i1 = Integer.valueOf(s1[0]);
				Integer i2 = Integer.valueOf(s2[0]);
				if (i1.compareTo(i2) == 0) {
					if (Integer.valueOf(s1[1]).compareTo(Integer.valueOf(s2[1])) == 0) {
						return Integer.valueOf(s1[2]).compareTo(Integer.valueOf(s2[2]));
					} else {
						return Integer.valueOf(s1[1]).compareTo(Integer.valueOf(s2[1]));
					}
				} else {
					return i1.compareTo(i2);
				}
			}
		});
		for (int b = 1; b < limit; b++) {
			for (int a = 1; a <= b; a++) {
				Map<Integer, Integer> numerator = Euler.primeFactorMap(a+b);
				Map<Integer, Integer> denominator = Euler.primeFactorMap(a,b);
				boolean funker = true;
				int trenger = 0;
				for (Map.Entry<Integer, Integer> factor : denominator.entrySet()) {
					int prime = factor.getKey();
					int pow = factor.getValue();
					if (!numerator.containsKey(prime))
						numerator.put(prime, 0);
							
					if (numerator.get(prime) < pow) {
						if (prime == 2 || prime == 5) {
							trenger = Math.max(trenger, pow-numerator.get(prime));
						} else {
							funker = false;
							break;
						}
					}
				}
				if (funker && trenger <= 3) {
					set.add(trenger + " "+ a + " " + b);
					for (String string : set) {
						System.out.println(string);
					}
					System.out.println(set.size());
					System.out.println(a + " " + b + " " + trenger);
				}
			}
		}
		
	}
}
