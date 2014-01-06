package problems;

import utils.Point;

import java.util.*;

public class Problem184 {
	
	private static final int r = 5;

	public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
		for (int x = -r+1; x < r; x++) {
			for (int y = -r+1; y < r; y++) {
				if (y*y+x*x >= r*r || (x == 0 && y == 0))
					continue;
                points.add(new Point(x, y));
			}
		}

        Set<String> tris = new HashSet<String>();
        for(Point a : points) {
            for(Point b : points) {
                if (a == b || origoBetween(a,b))
                    continue;
                for(Point c : points) {
                    if (a == c || b == c || origoBetween(a,c) || origoBetween(b,c))
                        continue;
                    double x1 = Math.signum(a.x*b.y-a.y*b.x);
                    double x2 = Math.signum(b.x*c.y-b.y*c.x);
                    double x3 = Math.signum(c.x*a.y-c.y*a.x);
                    if (x1==x2 && x2==x3) {
                        /**
                         * Dette er ganske piss, men resten er gull lizm
                         *
                         * kan finne noe spa matte ut fra disse formelene lizm
                         */
                        Set<Point> set = new TreeSet<Point>(new Comparator<Point>() {
                            @Override
                            public int compare(Point a, Point b) {
                                if (a.x == b.x) {
                                    return ((Double)a.y).compareTo(b.y);
                                }
                                return ((Double)a.x).compareTo(b.x);
                            }
                        });
                        set.addAll(Arrays.asList(a,b,c));
                        tris.add(set.toString());
                    }
                }
            }
        }
        System.out.println(tris.size());
	}

    private static boolean origoBetween(Point a, Point b) {
        return (a.x*b.x+a.y*b.y)*(a.x*b.x+a.y*b.y) == (a.x*a.x+a.y*a.y)*(b.x*b.x+b.y*b.y);
    }
}
