package problems;

import java.util.ArrayList;
import java.util.List;

import utils.Point;
import utils.T;

public class Problem222 {
	
	private static class Circle {
		Point center;
		int r;
		public Circle(Point center, int radius) {
			this.center = center;
			this.r = radius;
		}
		
		public String toMathematica() {
			return "Circle[{"+center.x+", "+center.y+"}, "+r+"]";
		}
	}
	public static void main(String[] args) {
		/**
		 * Kan redusere problemet til Œ putte 21 sirkler med tangent til 2 parallelle rette linjer med avstand 50mm
		 * 
		 * f¿rste sirkel (med radius r1): tangent til h¿yre linje og enden av r¿ret. Koordinater (r1,r1)
		 * 
		 * andre sirkel: tangent til venstre linje og f¿rste sirkel. Koordinater (50-r2, ?)
		 * 
		 * tredje sirkel: tangent til h¿yre linje og andre sirkel. Koordinater (r3, ?)
		 * 
		 * osv
		 * 
		 * http://mathworld.wolfram.com/TangentCircles.html
		 * 
		 * http://en.wikipedia.org/wiki/Tangent_lines_to_circles
		 */
		
		T t = new T();
		
		boolean left = true;
		
		int r1 = 47;
		int r2 = 30;
		int r3 = 43;
		int r4 = 37;
		
		
		Circle circle1 = new Circle(new Point(((left = !left) ? 100-r1 : r1),r1), r1);
		
		double x2 = ((left = !left) ? 100-r2 : r2);
		double y2 = findY(circle1, r2, x2, circle1.center.y, circle1.center.y+100);
		
		Circle circle2 = new Circle(new Point(x2, y2), r2);
		
		double x3 = ((left = !left) ? 100-r3 : r3);
		double y3 = findY(circle2, r3, x3, circle2.center.y, circle2.center.y+100);
		
		Circle circle3 = new Circle(new Point(x3, y3), r3);
		
		double x4 = ((left = !left) ? 100-r4 : r4);
		double y4 = findY(circle3, r4, x4, circle3.center.y, circle3.center.y+100);
		
		Circle circle4 = new Circle(new Point(x4, y4), r4);
		
		
		System.out.println("Plott dette i mathematica :)");
		System.out.println("Graphics[{Line[{{0, 0}, {0, 500}}], Line[{{100, 0}, {100, 500}}], " +
				circle1.toMathematica() +", " +
				circle2.toMathematica() +", " +
				circle3.toMathematica()+", " +
				circle4.toMathematica()+"}]");
		
		System.out.println(t);
	}

	/**
	 * denne b¿r v¾re bin¾rs¿k noobface
	 */
	private static double findY(Circle circle1,int r2, double x1, double minY, double maxY) {
		if (maxY-minY < 0.0000000000001)
			return minY;
		
		int r1 = circle1.r;
		Point center1 = circle1.center;
		
		
		double avgY = (minY+maxY)/2;
		double right = Math.pow((r1+r2), 2);
		double left = Math.pow((center1.x-x1),2) + Math.pow((center1.y-avgY),2);
		
		System.out.println(right);
		System.out.println(left);
		
		if (left < right) {
			return findY(circle1, r2, x1, avgY, maxY);
		} else {
			return findY(circle1, r2, x1, minY, avgY);
		}
	}
}
