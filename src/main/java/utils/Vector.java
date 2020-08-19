package utils;

import java.text.DecimalFormat;



public class Vector {
	private static final DecimalFormat DF = new DecimalFormat("0.00");
	public final double x;
	public final double y;

	public Vector(Point a, Point b) {
		this.x = b.x - a.x;
		this.y = b.y - a.y;
	}

	public String toString() {
		return "<" + DF.format(x) + ", " + DF.format(y) + ">";
	}
	
	public double dot(Vector other) {
		return x*other.x+y*other.y;
	}
	
	public double length() {
		return Math.sqrt(x*x+y*y);
	}
	
	public double theta(Vector other) {
		double temp =  Math.acos(this.dot(other)/(this.length()*other.length()));
		return Math.min(Math.PI-temp, temp);
	}
	
	public double angle(Vector other) {
		return theta(other)*57.2957795;
	}
}
