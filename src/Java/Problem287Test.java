package Java;

import utils.T;

public class Problem287Test {
	static int n = 24;
	
	static long centerX = (long)Math.pow(2, n-1);
	static long centerY = (long)Math.pow(2, n-1);
	
	
	private static class Point {
		long x;
		long y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Bounds {
		static long R = (long)Math.pow(2, 2*n-2);
		Point a;
		Point b;
		public Bounds(Point a, Point b) {
			this.a = a;
			this.b = b;
		}
		
		public boolean allWhite() {
			long x1 = a.x;
			long x2 = b.x;
			
			long y1 = a.y;
			long y2 = b.y;
			
			long dist1 = (centerX-x1)*(centerX-x1)+(centerY-y1)*(centerY-y1);
			long dist2 = (centerX-x1)*(centerX-x1)+(centerY-y2)*(centerY-y2);
			long dist3 = (centerX-x2)*(centerX-x2)+(centerY-y1)*(centerY-y1);
			long dist4 = (centerX-x2)*(centerX-x2)+(centerY-y2)*(centerY-y2);
			
			return Math.min(dist1, Math.min(dist2, Math.min(dist3, dist4))) > R;
		}
		
		public boolean allBlack() {
			long x1 = a.x;
			long x2 = b.x;
			
			long y1 = a.y;
			long y2 = b.y;
			
			long dist1 = (centerX-x1)*(centerX-x1)+(centerY-y1)*(centerY-y1);
			long dist2 = (centerX-x1)*(centerX-x1)+(centerY-y2)*(centerY-y2);
			long dist3 = (centerX-x2)*(centerX-x2)+(centerY-y1)*(centerY-y1);
			long dist4 = (centerX-x2)*(centerX-x2)+(centerY-y2)*(centerY-y2);
			
			return Math.max(dist1, Math.max(dist2, Math.max(dist3, dist4))) <= R;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		System.out.println(encodeStart(new Bounds(new Point(0,0), new Point((long)Math.pow(2, n)-1,(long)Math.pow(2, n)-1))) + " "+ t);
	}
	
	private static long encodeStart(Bounds bounds) {
		long maxX = Math.max(bounds.a.x, bounds.b.x);
		long minX = Math.min(bounds.a.x, bounds.b.x);
		long maxY = Math.max(bounds.a.y, bounds.b.y);
		long minY = Math.min(bounds.a.y, bounds.b.y);
		
		long l = (maxX-minX)/2;
		
		return 1+encode(new Bounds(new Point(minX, minY), new Point(minX+l, minY+l))) + 
				encode(new Bounds(new Point(minX, maxY), new Point(minX+l, maxY-l))) +
				encode(new Bounds(new Point(maxX, maxY), new Point(maxX-l, maxY-l))) +
				encode(new Bounds(new Point(maxX, minY), new Point(maxX-l, minY+l)));
	}

	private static long encode(Bounds bounds) {
		if (bounds.allBlack()) {
			return 2;
		} else if (bounds.allWhite()) {
			return 2;
		} else {
			long maxX = Math.max(bounds.a.x, bounds.b.x);
			long minX = Math.min(bounds.a.x, bounds.b.x);
			long maxY = Math.max(bounds.a.y, bounds.b.y);
			long minY = Math.min(bounds.a.y, bounds.b.y);
			
			long l = (maxX-minX)/2;
			
			return 1+encode(new Bounds(new Point(minX, minY), new Point(minX+l, minY+l))) + 
					encode(new Bounds(new Point(minX, maxY), new Point(minX+l, maxY-l))) +
					encode(new Bounds(new Point(maxX, maxY), new Point(maxX-l, maxY-l))) +
					encode(new Bounds(new Point(maxX, minY), new Point(maxX-l, minY+l)));
		}
	}
}
