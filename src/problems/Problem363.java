package problems;

import java.math.BigDecimal;

import utils.Point;
import utils.T;

public class Problem363 {
	
	static double v = 2-Math.sqrt(1.0/3.0*(22-5*Math.PI));
	public static void main(String[] args) {
		
		/**
		 * SE PAA v DEN ER SPA OG FIN OG SAANN
		 */

		T t = new T();
		double L = integrate();
		double ans = 100*(L-Math.PI/2)/(Math.PI/2);
		System.out.println(BigDecimal.valueOf(ans) + " " + t);
	}
	
	public static double integrate() {
		double b = 1;
		double a = 0;
		int n = 1000;
		double h = (b - a) / n;
		double s = f(a) + f(b);

		for (int i = 1; i < n; i += 2) {
			s += 4*f(i*h);
		}
		for (int i = 2; i < n - 1; i += 2) {
			s += 2*f(i*h);
		}
		return s * h / 3;
	}

	private static double f(double t) {
		return Math.sqrt(9*(-1+t)*(-1+t)*Math.pow((t*(2-3*v)+v),2)+9* t*t *Math.pow((2-2*v+t*(-2+3*v)),2)); 
	}

	private static Point B(double t) {
		return new Point(x(t), y(t));
	}

	private static double y(double t) {
		return t*(t*(3-6*v)+3*v+t*t*(-2+3*v));
	}

	private static double x(double t) {
		return (1-t)*(1+t+t*t*(-2+3*v));
	}
}
