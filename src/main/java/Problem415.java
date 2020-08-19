import java.util.ArrayList;
import java.util.List;

import utils.Euler;

public class Problem415 {
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "("+x+", "+y+")";
		}
	}
	public static void main(String[] args) {
		System.out.println(T(2));
	}

	//2^(N^3) kjretid yeah buddi
	private static int T(int N) {
		List<Point> points = new ArrayList<Point>();
		for (int x = 0; x <= N; x++) {
			for (int y = 0; y <= N; y++) {
				points.add(new Point(x, y));
			}
		}
		
		int pow = (N+1)*(N+1);
		for (int i = 0; i < Math.pow(2, pow); i++) {
			List<Point> subset = getSubset(points, Euler.toBinaryString(i, pow));
			
			if (isTitanicSet(subset)) {
				System.out.println(subset);
			}
		}
		
		System.out.println(points);
		return 0;
	}

	//denne funker ikke hh
	private static boolean isTitanicSet(List<Point> subset) {
		if (subset.size() < 2)
			return false;
		
		for (int i = 0; i < subset.size(); i++) {
			Point a = subset.get(i);
			for (int j = i+1; j < subset.size(); j++) {
				Point b = subset.get(j);
				
				//TODO : legge linjer i set og se om det kun er unike linjer der
				System.out.println(a + " " + b);
			}
		}
		return true;
	}

	private static List<Point> getSubset(List<Point> points, String binaryString) {
		List<Point> subset = new ArrayList<Point>();
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') 
				subset.add(points.get(i));
		}
		return subset;
	}
}
