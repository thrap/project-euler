package problems;

import java.util.ArrayList;
import java.util.List;

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

		public void addRed(Point tuple) {
			lines.add(new Line(tuple, Color.RED));
		}

		public void addBlack(Point tuple) {
			lines.add(new Line(tuple, Color.BLACK));
		}

		public void addGreen(Point tuple) {
			lines.add(new Line(tuple, Color.GREEN));
		}

		public void addPink(Point tuple) {
			lines.add(new Line(tuple, Color.PINK));
		}

		public void addOrange(Point tuple) {
			lines.add(new Line(tuple, Color.ORANGE));
		}

		public void addBlue(Point tuple) {
			lines.add(new Line(tuple, Color.BLUE));
		}
	}
	public static void main(String[] args) {
		int n = 36;
		List<Tuple> list = getTupleList(n);
		
		for (Tuple tuple : list) {
			System.out.println(tuple);
			System.out.println(tuple.lines);
		}
		
//		System.exit(0);
		
		/**
		 * mangler:
		 * (0, 0) (2, 1) (1, 2)
		 * (0, 0) (4, 0) (1, 2)
		 */
		
		long count = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
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
		System.out.println(count);
	}
	private static List<Tuple> getTupleList(int n) {
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
			System.out.println(startY + " " + startX + " " + endX);
			for (int i = 0; i < HEIGHT; i++) {
				int y = startY + i;
				
				if (y % HEIGHT == 0) {
					for (int x = startX; x <= endX; x+= 2) {
						Tuple tuple = new Tuple(x, y);
						tuple.addRed(new Point(startX, startY));
						tuple.addBlack(new Point(x, 0));
						if (x % 4 == startX % 4) {
							int greenStartX = x;
							int greenStartY = y;
							while(greenStartX - 6 >= 0 && greenStartY - 4 >= 0) {
								greenStartX -= 6;
								greenStartY -= 4;
							}
							tuple.addGreen(new Point(greenStartX, greenStartY));
							
							int pinkStartX = x;
							int pinkStartY = y;
							while(pinkStartX + 6 <= 4*n && pinkStartY - 4 >= 0) {
								pinkStartX += 6;
								pinkStartY -= 4;
							}
							tuple.addPink(new Point(pinkStartX, pinkStartY));
							
							int blueStartX = x;
							int blueStartY = y;
							while(blueStartX -2 >= 0 && blueStartY - 4 >= 0) {
								blueStartX -= 2;
								blueStartY -= 4;
							}
							tuple.addBlue(new Point(blueStartX, blueStartY));
							
							/**
							 * (2, 4): orange blir (2, 4)?
							 */
							int orangeStartX = x;
							int orangeStartY = y;
							if (x == 2 && y == 4) {
								System.out.println(orangeStartX + " " + orangeStartY);
							}
							while(orangeStartX + 2 <= 4*n && orangeStartY - 4 >= 0) {
								orangeStartX += 2;
								orangeStartY -= 4;
							}
							tuple.addOrange(new Point(orangeStartX, orangeStartY));
						} 
						list.add(tuple);
					}
				} else if (y % HEIGHT == 1) {
					for (int x = startX + 2; x <= endX-2; x+=4) {
						Tuple tuple = new Tuple(x, y);
						tuple.addBlack(new Point(x, 0));
						
						int greenStartX = x-2;
						int greenStartY = y-1;
						while(greenStartX - 6 >= 0 && greenStartY - 4 >= 0) {
							greenStartX -= 6;
							greenStartY -= 4;
						}
						tuple.addGreen(new Point(greenStartX, greenStartY));
						
						int pinkStartX = x+2;
						int pinkStartY = y-1;
						while(pinkStartX + 6 <= 4*n && pinkStartY - 4 >= 0) {
							pinkStartX += 6;
							pinkStartY -= 4;
						}
						tuple.addPink(new Point(pinkStartX, pinkStartY));
						
						list.add(tuple);
					}
				} else if (y % HEIGHT == 2) {
					for (int x = startX+1; x <= endX-1; x+=2) {
						Tuple tuple = new Tuple(x, y);
						
						if (x % 4 == (startX + 1) % 4) {
							int blueStartX = x-1;
							int blueStartY = y-2;
							while(blueStartX -2 >= 0 && blueStartY - 4 >= 0) {
								blueStartX -= 2;
								blueStartY -= 4;
							}
							tuple.addBlue(new Point(blueStartX, blueStartY));
							
							int pinkStartX = x+3;
							int pinkStartY = y-2;
							while(pinkStartX + 6 <= 4*n && pinkStartY - 4 >= 0) {
								pinkStartX += 6;
								pinkStartY -= 4;
							}
							tuple.addPink(new Point(pinkStartX, pinkStartY));
						} else if (x % 4 == (startX + 3) % 4) {
							int greenStartX = x-3;
							int greenStartY = y-2;
							while(greenStartX - 6 >= 0 && greenStartY - 4 >= 0) {
								greenStartX -= 6;
								greenStartY -= 4;
							}
							tuple.addGreen(new Point(greenStartX, greenStartY));
							
							int orangeStartX = x+1;
							int orangeStartY = y-2;
							while(orangeStartX + 2 <= 4*n && orangeStartY - 4 >= 0) {
								orangeStartX += 2;
								orangeStartY -= 4;
							}
							tuple.addOrange(new Point(orangeStartX, orangeStartY));
						}
						list.add(tuple);
					}
				} else if (y % HEIGHT == 3) {
					for (int x = startX+4; x <= endX-4; x+=4) {
						Tuple tuple = new Tuple(x, y);
						tuple.addBlack(new Point(x, 0));
						
						int greenStartX = x+2;
						int greenStartY = y+1;
						while(greenStartX - 6 >= 0 && greenStartY - 4 >= 0) {
							greenStartX -= 6;
							greenStartY -= 4;
						}
						tuple.addGreen(new Point(greenStartX, greenStartY));
						
						int pinkStartX = x-2;
						int pinkStartY = y+1;
						while(pinkStartX + 6 <= 4*n && pinkStartY - 4 >= 0) {
							pinkStartX += 6;
							pinkStartY -= 4;
						}
						tuple.addPink(new Point(pinkStartX, pinkStartY));
						
						list.add(tuple);
					}
				}
			}
		}
		return list;
	}
}
