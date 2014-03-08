package problems;

import java.text.DecimalFormat;

public class Problem144Matte2 {
	
	private static class Vector {
		
		final private double i;
		final private double j;
		
		public Vector(double startx, double starty, double endx, double endy) {
			this(endx - startx, endy - starty);
		}
		
		public Vector(double i, double j) {
			this.i = i;
			this.j = j;
		}
		
		public Vector negate() {
			return new Vector(-i,-j);
		}
		
		public double dot(Vector other) {
			return i*other.i+j*other.j;
		}
		
		public double length() {
			return Math.sqrt(i*i+j*j);
		}
		
		public double theta(Vector other) {
			double temp =  Math.acos(this.dot(other)/(this.length()*other.length()));
			return Math.min(Math.PI-temp, temp);
//			return Math.acos(this.dot(other)/(this.length()*other.length()));
		}
		
		public double angle(Vector other) {
			return theta(other)*57.2957795;
		}
		
		public String toString() {
			return "<"+i+","+j+">";
		}
	}
	
	private static class Point {
		final double x,y;
		public Point(double x, double y) {
			this.x=x;
			this.y = y;
		}
		public String toString() {
			return "["+df.format(x)+" "+df.format(y)+"]";
		}
	}
	static DecimalFormat df = new DecimalFormat("0.0000");
	
	private static class Line {
		
		Point p;
		
		private static double EPSILON = 0.00001;
		public Line(Vector v, double x, double y) {
			double a = v.j/(v.i);
			double b = -v.j*x/v.i+y;
			
			if (debug)
				System.out.println(a+"x"+" + "+b);

			double x1 = (-a*b-2*Math.sqrt(100+25*a*a-b*b))/(4+a*a);
			double x2 = (-a*b+2*Math.sqrt(100+25*a*a-b*b))/(4+a*a);
			
			if (debug)
				System.out.println(x+" "+x1 + " "+x2);
			if (Math.abs(x1-x) < EPSILON && Math.abs(x2-x) < EPSILON) {
				System.out.println("Todo");
				System.exit(0);
			} else if (Math.abs(x2-x) < EPSILON) {
				double y1 = x1*a+b;
				p=new Point(x1,y1);
			} else if (Math.abs(x1-x) < EPSILON) {
				double y2 = x2*a+b;
				p=new Point(x2,y2);
			} else {
				System.out.println("Todo lol");
				System.exit(0);
			}
		}
		
		
	}
	
	private static final Vector Xaxis = new Vector(1, 0);
	private static final Vector Xminusaxis = new Vector(1, 0);
	
	public static void main(String[] args) {
		Point start = new Point(0, 10.1);
		Point end = new Point(1.4, -9.6);
		System.out.println("ezplot('x^2/25+y^2/100=1')");
		System.out.println("axis([-15 15 -15 15])");
		for (int i = 2; true; i++) {
			if (true)
				System.out.println("line( [" +df.format(start.x) + " " + df.format(end.x)+"],["+ df.format(start.y) + " " + df.format(end.y)+"])");
			Point temp = end;
			end = getNewPoint(start, end);
			start = temp;
//			System.out.println(i + " " + end);
			if (Math.abs(end.x) <= 0.01 && end.y >0) {
				System.out.println("FERDIG "+(i-1) +" sprett");
				System.exit(0);
			}
		}
//		System.out.println(end + " " + start);
//		System.out.println(getNewPoint(end, start));
	}
	static boolean debug = false;
	public static Point getNewPoint(Point start, Point end) {
		double startX = start.x;
		double startY = start.y;
		double endX = end.x;
		double endY = end.y;
		
		Vector beam = new Vector(startX, startY, endX, endY);
		Vector tangent = new Vector(1, -4*endX/endY);
		
		double angle;
		if (Math.signum(startX) == Math.signum(endX)) {
			if (startX < 0) {
				//tror ikke denne er helt til aa stole paa
				angle = Xaxis.theta(tangent)-beam.negate().theta(tangent);
			} else {
				angle = Math.PI+Xaxis.theta(tangent)-beam.negate().theta(tangent);
			}
		} else if (startX < endX) {
			if (endY < 0) {
				angle = Math.PI + Xaxis.theta(tangent)-beam.negate().theta(tangent);
			} else {
				angle = -Xaxis.theta(tangent)-beam.negate().theta(tangent.negate());
			}
		} else {
			if (endY < 0) {
				angle = Math.PI - Xminusaxis.theta(tangent) -beam.negate().theta(tangent);
			} else {
				angle = Xaxis.theta(tangent) -beam.negate().theta(tangent.negate());
			}
		}
		
		return new Line(new Vector(Math.cos(angle), Math.sin(angle)), endX, endY).p;
	}
}
