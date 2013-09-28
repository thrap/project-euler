package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.Euler;


public class Problem273 {
	public static void main(String[] args) throws IOException {
		/**
		 * getNS funker som faen lizm, S(N) igjen da.. hæhæ
		 * 
		 * denne likner veldig på 233?
		 * 
		 * 
		 	sum = 0;
			j = 0;
			Do[
			 p = Solve[a^2 + b^2 == n && 0 <= a <= b, {a, b}, Integers];
			 q = a  /. p;
			 Do[sum += i, {i, q}];
			 If[Mod[++j, 1000] == 0, Print[j]; Print[sum]], {n, 
			  ReadList["/Users/thrap/Dropbox/Project Euler/problem273.txt", 
			   Number]}]
			Print[sum]
		 */
		int count = 0;
		StringBuilder a = new StringBuilder();
		for (BigInteger N : getNs()) {
			System.out.println(N);
			a.append(N + "\n");
			count++;
		}
		BufferedWriter pw = new BufferedWriter(new PrintWriter("/Users/thrap/Dropbox/Project Euler/problem273.txt"));
		pw.write(a.toString());
		pw.close();
		System.out.println(count + " tall å sjekke (2^" + getPrimes().size()+")");
	}
	

	private static List<BigInteger> getNs() {
		List<BigInteger> Ns = new ArrayList<BigInteger>();
		List<Integer> primes = getPrimes();
		
		for (int i = 0; i < Math.pow(2, primes.size()); i++) {
			String boolString = Euler.toBinaryString(i, primes.size()); 
			BigInteger N = BigInteger.ONE;
			for (int j = 0; j < primes.size(); j++) {
				if (boolString.charAt(j) == '1') {
					N = N.multiply(BigInteger.valueOf(primes.get(j)));
				}
			}
			Ns.add(N);
		}
		return Ns;
	}
	
	private static List<Integer> getPrimes() {
		List<Integer> primes = new ArrayList<Integer>();
		for (int prime : Euler.primeList(150)) {
			if ((prime - 1) % 4 == 0)
				primes.add(prime);
		}
		return primes;
	}
}
