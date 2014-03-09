package Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Point3d;
import utils.T;

public class Problem360 {
	public static void main(String[] args) {
		/**
		 * http://en.wikipedia.org/wiki/Pythagorean_quadruple
		 */
		
		int R = 45;
		T t = new T();
		Set<Point3d> set = new HashSet<Point3d>();
		for (int m = 1; m*m <= R; m++) {
			for (int n = 0; m*m+n*n <= R; n++) {
				for (int p = 0; m*m+n*n+p*p <= R && p*p <= m*m+n*n; p++) {
					for (int q = 0; m*m+n*n+p*p+q*q <= R && p*p-q*q <= m*m+n*n; q++) {
						int x = m*m+n*n-p*p-q*q;
						int y = 2*m*q+2*n*p;
						int z = 2*n*q-2*m*p;
						int r = m*m+n*n+p*p+q*q;
						if (r == R || R % r == 0) {
							int k = R / r;
							Point3d point = new Point3d(k*x,k*y,k*z);
							if (point.x >= 0) {
								set.add(point);
							}
							
						}
					}
				}
			}
		}
		
		System.out.println(set.size());
		
		int count = 0;
		long sum = 0;
		for (Point3d point : set) {
			int x = point.x;
			int y = point.y;
			int z = point.z;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(x, (map.containsKey(x) ? map.get(x) : 0) + 1);
			map.put(y, (map.containsKey(y) ? map.get(y) : 0) + 1);
			map.put(z, (map.containsKey(z) ? map.get(z) : 0) + 1);
			int permutations;
			if (map.size() == 3) {
				if (!map.containsKey(0)) {
					permutations = (3*2)*2*2*2;
				} else {
					permutations = (3*2)*2*2;
				}
			} else if (map.size() == 2) {
				if (!map.containsKey(0)) {
					permutations = (3)*2*2*2;
				} else {
					int zeros = map.get(0);
					if (zeros == 2) {
						permutations = (3)*2;
					} else {
						permutations = (3)*2*2;
					}
				}
			} else {
				permutations = 2*2*2;
			}
			sum += permutations*(x+y+z);
			count+=permutations;
		}
		System.out.println(sum + " "+count + " " + t);
	}
}
