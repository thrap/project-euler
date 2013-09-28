package problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import utils.Rational;

public class Problem165 {
	private static class Random165 {
		private BigInteger number = BigInteger.valueOf(290797);
		
		public int next() {
			number = number.pow(2).mod(BigInteger.valueOf(50515093L));
			return number.mod(BigInteger.valueOf(500)).intValue();
		}
	}
	
	private static class Line {
		private Rational a;
		private Rational b;
		private long startX;
		private long endX;
		private long startY;
		private long endY;
		
		public Line(int startX, int startY, int endX, int endY) {
			if (startX < endX) {
				this.startX = startX;
				this.endX = endX;
				this.startY = startY;
				this.endY = endY;
			} else {
				this.startX = endX;
				this.endX = startX;
				this.startY = endY;
				this.endY = startY;
			}
			
			a = new Rational((endY-startY), (endX-startX));
			b = a.multiply(new Rational(-endX, 1)).add(new Rational(endY, 1));
		}
		
		public boolean isVertical() {
			return startX == endX;
		}
		
		public String toString() {
			return a.toString() + "*x" + " +"+b.toString();
		}
		
		public Rational intersects(Line line) {
			if (isVertical()) {
				return new Rational(startX, 1);
			} else if (line.isVertical()) {
				return new Rational(line.startX, 1);
			}
			
			Rational x = a.subtract(line.a);
			return line.b.subtract(b).divide(x);
		}
		
		public boolean hasTrueIntersection(Line line) {
			//ellers er det uendelig mange punkter
			if (isVertical() && line.isVertical())
				return false;
			if (line.b.n == b.n && line.b.d == b.d)
				return false;
			
			Rational x = intersects(line);
			if (x.isLessThan(new Rational(startX, 1)) || x.isLessThan(new Rational(line.startX,1))) {
				return false;
			} else if (new Rational(endX, 1).isLessThan(x) || new Rational(line.endX,1).isLessThan(x)) {
				return false;
			} else if (isVertical()) {
				if(x.d == 1 && (line.startX == x.n || line.endX == x.n))
					return false;
				return true;
			} else if (line.isVertical()) {
				if (x.d == 1 && (startX == x.n || endX == x.n))
					return false;
				return true;
			} else if (x.d == 1 && (startX == x.n || endX == x.n || line.startX == x.n || line.endX == x.n)) {
				return false;
			} else {
				return true;
			}
		}

		public boolean containsY(Rational y) {
			long maxY = Math.max(startY, endY);
			long minY = Math.min(startY, endY);
			
			if (y.isLessThan(new Rational(minY, 1))) {
				return false;
			} else if (new Rational(maxY, 1).isLessThan(y)) {
				return false;
			} else if (maxY == minY)  {
				return true;
			} else if (y.d == 1 && (startY == y.n || endY == y.n)) {
				return false;
			} else {
				return true;
			}
		}
		
		public Rational getY(Rational x) {
			return x.multiply(a).add(b);
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		
		Random165 r = new Random165();
		Line[] lines = new Line[5000];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(r.next(), r.next(), r.next(), r.next());
		}
		
		Set<String> points = new HashSet<String>();
		for (int i = 0; i < lines.length; i++) {
			Line line = lines[i];
			if (i % 100 == 0)
				System.out.println(i);
			for (int j = i+1; j < lines.length; j++) {
				if (line.hasTrueIntersection(lines[j])) {
					Rational x = line.intersects(lines[j]);
					Rational y = (line.isVertical() ? lines[j].getY(x) : line.getY(x));
					if (line.containsY(y) && lines[j].containsY(y)) {
						points.add("("+x.toString() + ", "+y.toString()+")");
					} 
				}
			}
		}
		System.out.println(points.size() + " ("+(System.currentTimeMillis()-start)+ " ms)");
	}
}
