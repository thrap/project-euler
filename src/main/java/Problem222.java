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
	}
	
	/**
	 * Se Problem222BaseCase for plotting
	 */
	public static void main(String[] args) {
		T t = new T();
		int[] rs = {50, 48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49};
		
		boolean left = false;
		Circle lastCircle = new Circle(new Point(((left = !left) ? 100-rs[0] : rs[0]),rs[0]), rs[0]);
		for (int i = 1; i < rs.length; i++) {
			int r = rs[i];
			double x = ((left = !left) ? 100-r : r);
			lastCircle = new Circle(new Point(x, findY(lastCircle, r, x)), r);
		}
		
		double length = lastCircle.center.y+lastCircle.r;
		System.out.println("Length: " + Math.round((length/1000)*1e6) + " micrometers " + t);
	}

	
	private static double findY(Circle circle, int r, double x) {
		return findY(circle.r, circle.center.x, circle.center.y, r, x, circle.center.y, circle.center.y+100);
	}
	
	private static double findY(int r1, double x0, double y0, int r2, double x1, double y1min, double y1max) {
		if (y1max-y1min < 1e-9)
			return y1min;
		
		double y1 = (y1min+y1max)/2;
		
		if ((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1) < (r1+r2)*(r1+r2)) {
			return findY(r1, x0, y0, r2, x1, y1, y1max);
		} else {
			return findY(r1, x0, y0, r2, x1, y1min, y1);
		}
	}
}
