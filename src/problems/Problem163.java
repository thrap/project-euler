package problems;

import java.util.ArrayList;
import java.util.List;

import utils.T;

public class Problem163 {
	
	private static enum Color {
		BLACK("black"), RED("red"), GREEN("green"), PINK("pink"), ORANGE("orange"), BLUE("blue");
		String str;
		Color(String str) {
			this.str = str;
		}
		
		public String toString() {
			return str;
		}
	}
	
	private static class Line {
		Point point;
		Color color;
		public Line(Point point, Color color) {
			this.point = point;
			this.color = color;
		}
		
		public boolean equals(Line line) {
			return line.point.equals(point) && line.color.equals(color);
		}
		
		public String toString() {
			return color.toString() + " " + point.toString();
		}
	}
	
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Point p) {
			return x == p.x && y == p.y;
		}
		
		public String toString() {
			return "("+x + ", "+y+")";
		}
	}
	private static final int HEIGHT = 4;
	private static class Tuple {
		int x, y;
		
		List<Line> lines = new ArrayList<Line>();

		public Tuple(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "("+x + ", "+y+")";
		}

		public void addRed(Point p) {
			lines.add(new Line(p, Color.RED));
		}

		public void addBlack(Point p) {
			lines.add(new Line(p, Color.BLACK));
		}

		public void addGreen(Point p) {
			while(p.x - 6 >= 0 && p.y - 4 >= 0) {
				p.x -= 6;
				p.y -= 4;
			}
			lines.add(new Line(p, Color.GREEN));
		}

		public void addPink(Point p) {
			while(p.x + 6 <= 4*n && p.y - 4 >= 0) {
				p.x += 6;
				p.y -= 4;
			}
			lines.add(new Line(p, Color.PINK));
		}

		public void addOrange(Point p) {
			while(p.x + 2 <= 4*n && p.y - 4 >= 0) {
				p.x += 2;
				p.y -= 4;
			}
			lines.add(new Line(p, Color.ORANGE));
		}

		public void addBlue(Point p) {
			while(p.x -2 >= 0 && p.y - 4 >= 0) {
				p.x -= 2;
				p.y -= 4;
			}
			lines.add(new Line(p, Color.BLUE));
		}
	}
	
	static int n = 36;
	public static void main(String[] args) {
		T t = new T();
		List<Tuple> list = getTupleList();
		
		long count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i % 50 == 0)
				System.out.println(i + " / " + list.size());
			Tuple a = list.get(i);
			for (int j = i+1; j < list.size(); j++) {
				Tuple b = list.get(j);
				for (Line line1 : a.lines) {
					for (Line line2 : b.lines) {
						if (line1.equals(line2)) {
							for (int k = j+1; k < list.size(); k++) {
								Tuple c = list.get(k);
								Line l1 = null;
								Line l2 = null;
								
								for (Line lineC : c.lines) {
									for (Line lineA : a.lines) {
										if (lineC.equals(lineA)) {
											l1 = lineA;
										}
									}
									for (Line lineB : b.lines) {
										if (lineB.equals(lineC)) {
											l2 = lineB;
										}
									}
								}
								if (l1 != null && l2 != null && !l1.equals(l2)) {
									count++;
								}
							}
							break;
						}
					}
				}
			}
		}
		System.out.println(count + " " + t);
	}
	private static List<Tuple> getTupleList() {
		List<Tuple> list = new ArrayList<Tuple>();
		
		Tuple firstTuple = new Tuple(n*2, n*HEIGHT);
		firstTuple.addBlack(new Point(n*2, 0));
		firstTuple.addBlue(new Point(0,0));
		firstTuple.addOrange(new Point(n*4, 0));
		list.add(firstTuple);
		
		
		for (int triangles = n; triangles >= 1; triangles--) {
			int startY = (n-triangles)*HEIGHT;
			int startX = (n-triangles)*2;
			int endX = n*4 - (n-triangles)*2;
			for (int i = 0; i < HEIGHT; i++) {
				int y = startY + i;
				switch(y % HEIGHT) {
				case 0: addLayer0(list, startY, startX, endX, y); break;
				case 1: addLayer1(list, startX, endX, y); break;
				case 2: addLayer2(list, startX, endX, y); break;
				case 3: addLayer3(list, startX, endX, y); break;
				}
			}
		}
		return list;
	}
	private static void addLayer3(List<Tuple> list, int startX, int endX, int y) {
		for (int x = startX+4; x <= endX-4; x+=4) {
			Tuple tuple = new Tuple(x, y);
			tuple.addBlack(new Point(x, 0));
			tuple.addGreen(new Point(x+2, y+1));
			tuple.addPink(new Point(x-2, y+1));
			list.add(tuple);
		}
	}
	private static void addLayer2(List<Tuple> list, int startX, int endX, int y) {
		for (int x = startX+1; x <= endX-1; x+=2) {
			Tuple tuple = new Tuple(x, y);
			if (x % 4 == (startX + 1) % 4) {
				tuple.addBlue(new Point(x-1, y-2));
				tuple.addPink(new Point(x+3, y-2));
			} else if (x % 4 == (startX + 3) % 4) {
				tuple.addGreen(new Point(x-3, y-2));
				tuple.addOrange(new Point(x+1, y-2));
			}
			list.add(tuple);
		}
	}
	private static void addLayer0(List<Tuple> list, int startY, int startX,
			int endX, int y) {
		for (int x = startX; x <= endX; x+= 2) {
			Tuple tuple = new Tuple(x, y);
			tuple.addRed(new Point(startX, startY));
			tuple.addBlack(new Point(x, 0));
			if (x % 4 == startX % 4) {
				tuple.addGreen(new Point(x, y));
				tuple.addPink(new Point(x, y));
				tuple.addBlue(new Point(x, y));
				tuple.addOrange(new Point(x, y));
			} 
			list.add(tuple);
		}
	}
	private static void addLayer1(List<Tuple> list, int startX, int endX, int y) {
		for (int x = startX + 2; x <= endX-2; x+=4) {
			Tuple tuple = new Tuple(x, y);
			tuple.addBlack(new Point(x, 0));
			tuple.addGreen(new Point(x-2, y-1));
			tuple.addPink(new Point(x+2, y-1));
			list.add(tuple);
		}
	}
}
