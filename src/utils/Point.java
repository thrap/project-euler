package utils;

import java.text.DecimalFormat;

public class Point {
	private static final DecimalFormat DF = new DecimalFormat("0.00");
	public final double x;
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + DF.format(x) + ", " + DF.format(y) + ")";
	}

	public double distanceTo(Point t) {
		double x = t.x - this.x;
		double y = t.y - this.y;
		return Math.sqrt(x * x + y * y);
	}
}
