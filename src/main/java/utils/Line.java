package utils;



public class Line {
	private final Vector v;
	private final Point p;

	public Line(Point a, Point b) {
		this(new Vector(a, b), a);
	}
	
	public Line(Vector v, Point p) {
		this.v = v;
		this.p = p;
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
		double t = (((b2 / a2) * (x1 - x2) + y2 - y1) / b1)
				/ (1 - b2 * a1 / (a2 * b1));
		return new Point(v.x * t + p.x, v.y * t + p.y);
	}

	public String toString() {
		return v + "t + " + p;
	}
}
