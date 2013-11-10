package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Euler;
import utils.Point3d;
import utils.T;

public class Problem224BaseCase {
	public static void main(String[] args) {
		/**
		 * http://en.wikipedia.org/wiki/Pythagorean_quadruple
		 */
		int perimeter = 2300;
		int triangler = 0;
		T t1 = new T();
		Set<Point3d> correctPoints = new HashSet<Point3d>();
		for (int a = 0; a <= perimeter; a++) {
			for (int b = a; a+b <= perimeter; b++) {
				for (int c = b; a+b+c <= perimeter; c++) {
					if (a*a+b*b == c*c -1) {
						correctPoints.add(new Point3d(a,b,c));
						triangler++;
					}
				}
			}
		}
		
		System.out.println("riktig antall: "+triangler + " " + t1);
		T t2 = new T();
		Set<Point3d> set = new HashSet<Point3d>();
		for (long a = 0; a <= perimeter; a+=2) {
			if (a % 3000 == 0)
				System.out.println((double)a/perimeter + " %");
			for (long p : Euler.divisorList(a*a+1)) {
				int b = (int)((a*a+1-p*p)/(2*p));
				if (b < 0)
					continue;
				int c = (int)((a*a+1+p*p)/(2*p));
				if (a+b+c <= perimeter) {
					set.add(new Point3d((int)a,b,c));
				} 
			}
		}
		
		if (!correctPoints.containsAll(set)) {
			System.out.print("Din j¾vla pelle, correctPoints skal inneholde alle points");
			System.exit(0);
		}
		System.out.println("generert antall: "+set.size() + " " + t2);
		Set<Point3d> missingPoints = new HashSet<Point3d>(correctPoints);
		missingPoints.removeAll(set);
		System.out.println("DISSE PUNKTENE MANGLER");
		System.out.println(missingPoints);
	}
}
