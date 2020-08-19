import java.util.ArrayList;
import java.util.List;

import utils.Euler;
import utils.Point;
import utils.T;

public class Problem403BaseCase {
	public static void main(String[] args) {
		long n = 10000;
		long sum = 0;
		
		/**
		 * denne gr tregt fordi a*a+4*b sjelden blir perfect squares
		 */
		T t1 = new T();
		
		List<Point> points = new ArrayList<Point>();
		for (long a = 0; a <= n; a++) {
			for (long b = -Math.min(a*a/4, n); b <= n; b++) {
				if (Euler.isPerfectSquare(a*a+4*b)) {
					points.add(new Point(a,b));
				}
			}
		}
		
		System.out.println("Funnet points " + t1);
		
		T t2 = new T();
		
		for (Point point : points) {
			int a = (int) point.x;
			int b = (int) point.y;
			
			if (a == 0) 
				sum += L(a,b);
			else 
				sum += 2*L(a,b);
		}
		System.out.println("Regnet ut L   " + t2);
		System.out.println(sum);
		System.out.println(26709528);
	}

	/**
	 * denne funker gull inntil videre
	 */
	private static long L(long a, long b) {
		//disse gr bra fordi perfect square
		long lower = (a - (long)Math.sqrt(a*a+4*b))/2;
		long upper = (a + (long)Math.sqrt(a*a+4*b))/2;
		
		long count = 0;
		for (long x = lower; x <= upper; x++) {
			count+=a*x+b-x*x+1;
		}
		return count;
	}
}
