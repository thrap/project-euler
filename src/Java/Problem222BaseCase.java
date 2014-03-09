package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Euler;
import utils.Point;
import utils.T;

public class Problem222BaseCase {
	
	private static class Circle {
		Point center;
		int r;
		public Circle(Point center, int radius) {
			this.center = center;
			this.r = radius;
		}
		
		public String toMathematica() {
			return "Disk[{"+center.x+", "+center.y+"}, "+r+"]";
		}
	}
	public static void main(String[] args) {
		/**
		 * Kan redusere problemet til aa putte 21 sirkler med tangent til 2 parallelle rette linjer med avstand 50mm
		 * 
		 * frste sirkel (med radius r1): tangent til hoeyre linje og enden av rret. Koordinater (r1,r1)
		 * 
		 * andre sirkel: tangent til venstre linje og frste sirkel. Koordinater (50-r2, ?)
		 * 
		 * tredje sirkel: tangent til hyre linje og andre sirkel. Koordinater (r3, ?)
		 * 
		 * osv
		 * 
		 * http://mathworld.wolfram.com/TangentCircles.html
		 * 
		 * http://en.wikipedia.org/wiki/Tangent_lines_to_circles
		 */
		
		
		T t = new T();
		
		int balls = 9;
		
//		int[] rs = new int[balls];
//		for (int i = 0; i < rs.length; i++) {
//			rs[i] = (50-balls+1)+i;
//		}
		
		int[] rs = new int[balls];
		for (int i = 0; i < rs.length; i++) {
			rs[i] = (50-2*balls+1)+i*2;
		}
		
		double shortest = Double.MAX_VALUE;
		String mathematicaString = "";
		do{
			boolean left = false;
			List<Circle> circles = new ArrayList<Circle>();
			circles.add(new Circle(new Point(((left = !left) ? 100-rs[0] : rs[0]),rs[0]), rs[0]));
			for (int i = 1; i < rs.length; i++) {
				int r = rs[i];
				double x = ((left = !left) ? 100-r : r);
				double y = findY(circles.get(i-1), r, x);
				circles.add(new Circle(new Point(x, y), r));
			}
			
			Circle lastCircle = circles.get(circles.size()-1);
			double length = lastCircle.center.y+lastCircle.r;
			
			if (length <= shortest) {
				shortest = length;
				System.out.println(Arrays.toString(rs));	
				mathematicaString = "Graphics[{Line[{{0, 0}, {0, "+length+"}}], Line[{{100, 0}, {100, "+length+"}}], ";
				for (Circle circle : circles) {
					mathematicaString += circle.toMathematica() + ", ";
				}
				mathematicaString +="}]";
			}
		} while (Euler.permute(rs, rs.length));
		
		System.out.println("Skriv inn dette i mathematica :)");
		System.out.println(mathematicaString);
		
	}

	
	private static double findY(Circle circle, int r2, double x1) {
		return findY(circle.r, circle.center.x, circle.center.y, r2, x1, circle.center.y, circle.center.y+100);
	}
	
	private static double findY(int r1, double x0, double y0, int r2, double x1, double minY, double maxY) {
		if (maxY-minY < 0.000000000001)
			return minY;
		
		double avgY = (minY+maxY)/2;
		double right = Math.pow((r1+r2), 2);
		double left = Math.pow((x0-x1),2) + Math.pow((y0-avgY),2);
		
		
		if (left < right) {
			return findY(r1, x0, y0, r2, x1, avgY, maxY);
		} else {
			return findY(r1, x0, y0, r2, x1, minY, avgY);
		}
	}
}
