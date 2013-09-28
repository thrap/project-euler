package problems;

import java.text.DecimalFormat;

public class Problem143BaseCase {
	private static final DecimalFormat DF = new DecimalFormat("0.00"); 
	private static class Point {
		private double x;
		private double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		//C = (b^2+a^2-c^2)/2a, ±sqrt(b^2-x^2))
		public Point (double a, double b, double c) {
			this.x = (b*b+a*a-c*c)/(2*a);
			this.y = Math.sqrt(b*b-x*x);
		}
		public String toString() {
			return "("+DF.format(x)+", "+DF.format(y)+")";
		}

		public double distanceTo(Point t) {
			double x = t.x-this.x;
			double y = t.y-this.y;
			return Math.sqrt(x*x+y*y);
		}
	}
	
	private static class Vector {
		
		double x;
		double y;
		public Vector(Point a, Point b) {
			this.x = b.x-a.x;
			this.y = b.y-a.y;
		}
		
		public String toString() {
			return "<"+DF.format(x)+", "+DF.format(y)+">";
		}
	}
	
	private static class Line {
		Vector v;
		Point p;
		public Line(Point a, Point b) {
			this.v = new Vector(a, b);
			this.p = a;
		}
		
		public Point getIntersectionPoint(Line other) {
			double a1 = this.v.x;
			double a2 = other.v.x;
			double b1 = this.v.y;
			double b2 = other.v.y;
			double x1 = this.p.x;
			double x2 = other.p.x;
			double y1 = this.p.y;
			double y2 = other.p.y;
			double t = (((b2/a2)*(x1-x2)+y2-y1)/b1)/(1-b2*a1/(a2*b1));
			return new Point(v.x*t+p.x, v.y*t+p.y);
		}
		
		public String toString() {
			return v+"t + "+p;
		}
	}
	private static boolean PRINT_FOR_MATLAB = false;
	public static void main(String[] args) {
		/**
		 * dette l¿ser basecase, men gŒr for tregt til Œ l¿se en dritt ellers. finn pŒ noe smart du h¾h¾
		 */
		int a = 399, b = 455, c = 511;
		Point A = new Point(0, 0);
		Point B = new Point(c, 0);
		Point C = new Point(c, b, a);
		
		System.out.println(A + " " + B + " " + C);
		
		Point T = getTorricelliPoint(A,B,C,b,c);
		System.out.println("Torc x = " +T.x);
		double p = A.distanceTo(T);
		double r = B.distanceTo(T);
		double q = C.distanceTo(T);
		
		if (isIntegers(p,r,q) && q > 0.5) {
			System.out.println(p+" "+r + " "+q);
			System.out.println(p+r+q);
		}
		
		
	}
	
	private static Point getTorricelliPoint(Point A, Point B, Point C, int b,
			int c) {
		//O = (a*cos60, a*sin60)
		Point O = new Point(c*0.5, -c*Math.sin(Math.PI/3));
		
		double angle = Math.acos((B.x*C.x+B.y*C.y)/(c*b))+Math.PI/3;
		Point M = new Point(b*Math.cos(angle), b*Math.sin(angle));
		System.out.println(M);
		
		Line BM = new Line(B, M);
		Line CO = new Line(C, O);
		
		Point T = BM.getIntersectionPoint(CO);
		if (PRINT_FOR_MATLAB)
			printLinesForMatlab(A,B,C,M,O,T);
		return T;
	}

	private static void printLinesForMatlab(Point A, Point B, Point C, Point M,
			Point O, Point T) {
		line(A,B);
		line(A,C);
		line(B,C);
		line(A,M);
		line(C,M);
		line(A,O);
		line(B,O);
		line(B,M);
		line(C,O);
		line(A,T);
	}

	private static boolean isIntegers(double a, double b, double c) {
		return isInteger(a) && isInteger(b) && isInteger(c);
	}
	
	private static boolean isInteger(double d1) {
		return (d1 - Math.floor(d1) < 0.00000001) || (d1 - Math.floor(d1) > 0.99999999);
	}

	private static void line(Point a, Point b) {
		System.out.println("line(["+a.x+" "+b.x+"],"+ "["+a.y+" "+b.y+"])");
	}
}
