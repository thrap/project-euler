package problems;

import utils.Line;
import utils.Point;
import utils.Vector;

public class Problem163BaseCase {
	public static void main(String[] args) {
		// ytre
		int s = 3;
		Line red1 = new Line(new Point(0,0), new Point(s*4, 0));
		Line orange1 = new Line(new Point(s*4,0), new Point(s*2, s*4));
		Line blue1 = new Line(new Point(s*2,s*4), new Point(0, 0));
		
		System.out.println(red1);
		System.out.println(orange1);
		System.out.println(blue1);
		
		// indre
		Line green1 = new Line(new Point(0,0), new Point(s*6, s*4));
		Line pink1 = new Line(new Point(s*4,0), new Point(s*(-2), s*4));
		Line black1 = new Line(new Point(s*2,0), new Point(s*2, s*4));
		
		System.out.println(green1);
		System.out.println(pink1);
		System.out.println(black1);
		
		System.out.println(4+3+2+1+3+2+1+2+1+1);
		
		System.out.println(green1.getIntersectionPoint(pink1));
		System.out.println(green1.getIntersectionPoint(black1));
		System.out.println(pink1.getIntersectionPoint(black1));
		
		System.out.println(green1.getIntersectionPoint(orange1));
		System.out.println(pink1.getIntersectionPoint(blue1));
	}
}
