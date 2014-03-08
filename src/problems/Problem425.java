package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;

public class Problem425 {
	static int n = (int)Math.pow(10, 7);
	static boolean[] isPrime = Euler.primeArray(n);
	public static void main(String[] args) {
		List<Integer> primes = Euler.primeList(n);
		int i = 0;
		/** 
		 * er alle relations strre er det ikke mulig
		 * 
		 *******************************
		 * 
		 * SE P TALLET 103
		 * 
		 * lagre laveste connection til 2 lizm det blir bra
		 * 
		 * dette er fantastisk drlig kode haha men funker som faen
		 * 
		 ******************************* 
		 *
		 */
		
		Set<Integer> connected = new HashSet<Integer>();
		connected.add(2);
		for (Integer prime : primes) {
			if (i++ % 100000 == 0)
				System.out.println(prime);
			if (connected.contains(prime)) {
				for (Integer integer : getConnections(prime)) {
					if (integer > prime)
						connected.add(integer);
				}
			}
		}
		
		Map<Integer,Integer> lowest = new HashMap<Integer, Integer>();
		for (Integer prime : primes) {
			lowest.put(prime, Integer.MAX_VALUE);
			if (connected.contains(prime)) {
				for (Integer integer : getConnections(prime)) {
					if (lowest.containsKey(integer)) {
						lowest.put(integer, Math.min(lowest.get(integer), prime));
					} else {
						lowest.put(integer, prime);
					}
				}
			}
		}
		
		for (int j = 0; j < 100; j++) {
			System.out.println(j);
			for (Integer prime : primes) {
				if (prime < lowest.get(prime)) {
					for(Integer integer : getConnections(prime)) {
						int max = Math.max(integer, lowest.get(integer));
						lowest.put(prime, Math.min(max, lowest.get(prime)));
					}
				}
			}
			
			long count = 0;
			long sum = 0;
			for (Integer prime : primes) {
				if (prime < lowest.get(prime) && prime!=2) {
//					System.out.println(prime + " " + lowest.get(prime));
					sum += prime;
					count++;
				}
			}
			System.out.println(sum + " " + count);
		}
		
		
		
		
		
	}


	static Map<Integer, Set<Integer>> memo = new HashMap<Integer, Set<Integer>>();
	
	private static Set<Integer> getConnections(Integer prime) {
		if (memo.containsKey(prime))
			return memo.get(prime);
		Set<Integer> connections = new TreeSet<Integer>();
		int length = (int)Math.log10(prime);
		int ten = (int)Math.pow(10, length+1);
		for (int d = 0; d <= 9; d++) {
		
			
			int C = ten*d+prime;
			if (C < n && isPrime[C]) {
				connections.add(C);
			}
			
			for (int i = (d!=0?0:1); i <= length; i++) {
				String number = ""+prime;
				int D = Integer.parseInt(number.substring(0,i)+d+number.substring(i+1));
				if (isPrime[D]) {
					connections.add(D);
				}
			}
			
			if (prime >= 10) {
				int E = Integer.parseInt((""+prime).substring(1));
				if ((""+prime).charAt(1) != '0' && isPrime[E])
					connections.add(E);
			}
		}
		connections.remove(prime);
		return connections;
	}
}
