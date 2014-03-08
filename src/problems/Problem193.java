package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Euler;


public class Problem193 {
	static long limit = (long)Math.pow(2, 50);
	public static void main(String[] args) {
		System.out.println("rask  : "+solution());
	}
	
	
	
	public static long solution() {
		return raskOgRiktig(limit);
	}



	public static long treg(long limit) {
		long antall = limit-1;
		for (int i = 1; i < limit; i++) {
			for (int j = 2; j*j <= i; j++) {
				if (i%(j*j) == 0) {
					antall--;
					break;
				}
			}
		}
		return antall;
	}
	
	static class Square implements Comparable<Square> {
		long tall;
		boolean positive;
		
		public Square(long square, Square square2) {
			tall = square*square2.tall;
			positive = !square2.positive;
		}

		public Square(long square) {
			tall = square;
			positive = true;
		}

		long value(long limit) {
			return ((limit-1)/tall)*(positive?-1:1);
		}
		
		public String toString() {
			return ""+tall;
		}
		
		@Override
		public int compareTo(Square arg0) {
			return tall>arg0.tall?1:-1;
		}
	}
	
	public static long raskOgRiktig(long limit) {
		int sqrt = (int)Math.sqrt(limit)+1;
		List<Long> primes = Euler.primeListLong(sqrt);
		Set<Square> squares = new TreeSet<Square>();
		long antall = limit-1;
		int i = 0;
		for (long p : primes) {
			long square = p*p;
			antall-=(limit-1)/square;
			Set<Square> products = new HashSet<Square>();
			for (Square square2 : squares) {
				Square product = new Square(square, square2);
				if (product.tall < limit) {
					antall+=product.value(limit);
					if (square * square < limit && square <= 3037000499L) {
						products.add(product);
					} 
				} else {
					break;
				}
			}
			if (square*square < limit)
				squares.add(new Square(square));
			squares.addAll(products);
		}
		return antall;
	}
	public static long rask(long limit) {
		int sqrt = (int)Math.sqrt(limit)+1;
		List<Long> primes = Euler.primeListLong(sqrt);
		Set<Long> squares = new TreeSet<Long>();
		long antall = limit-1;
		int i = 0;
		for (long p : primes) {
			long square = p*p;
			antall-=(limit-1)/square;
			Set<Long> products = new HashSet<Long>();
			for (Long square2 : squares) {
				long product = square * square2;
				if (product < limit) {
					antall+=(limit-1)/product;
					if (square * square < limit && square <= 3037000499L) {
						products.add(product);
					} 
				} else {
					break;
				}
			}
			if (square*square < limit)
				squares.add(square);
			squares.addAll(products);
		}
		return antall;
	}
}
