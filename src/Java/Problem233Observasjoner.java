package Java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import utils.Euler;

public class Problem233Observasjoner {
	public static void main(String[] args) {
		for (long N : Euler.primeList(100)) {
			
			int points = points(N);
			
			if (points >= 12)
			System.out.println(N + " " + points);
		}
		
		System.out.println(points(pow(5,5)*13*13*5*3));
		
	}
	
	private static long pow(int x, int n) {
		return (long)(Math.pow(x,n));
	}

	static Set<Long> squares;
	static {
		squares = new LinkedHashSet<Long>();
		for (long i = 0; i <= 4733727; i++) {
			squares.add(i*i);
		}
	}
	
	public static int points(long N) {
		//13,29 -> 24
		//5 -> 8
		int points = 0;
		long Nsquare = N*N;
		
		for (Long square : squares) {
			if (square > Nsquare)
				break;
			if (squares.contains(Nsquare-square)) {
				Set<String> tempPoints = new HashSet<String>();
				long y = (long)Math.sqrt(Nsquare-square);
				long x = (long)Math.sqrt(square);
				long y1 = N-y;
				long y2 = N+y;
				long x1 = N-x;
				long x2 = N+x;
				
				tempPoints.add("("+x1+","+y1+")");
				tempPoints.add("("+x2+","+y1+")");
				tempPoints.add("("+x1+","+y2+")");
				tempPoints.add("("+x2+","+y2+")");
				
				points+=tempPoints.size();
			}
		}
		return points;
	}
}
