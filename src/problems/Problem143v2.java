package problems;

import utils.Euler;

import java.util.*;

public class Problem143v2 {
    private static class Triangle {
        long p;
        long q;

        public Triangle(long p, long q) {
            this.p = p;
            this.q = q;
        }

        public String toString() {
            return "("+p + ", " + q+")";
        }
    }
    public static void main(String[] args) {
        /**
         * The angles ATC, ATB and BTC are all 120 degrees
          */

        // skal finne alle kombinasjoner av trekanter der én vinkel er 120grader og alle lengder er integer


        // finds triangles
        List<Triangle> triangles = new ArrayList<Triangle>();
        Map<Long, List<Triangle>> map = new HashMap<Long, List<Triangle>>();

        int limit = 120000;
        for(long p = 1; p <= limit; p++) {
            if (p%1000 == 0)
                System.out.println(p + " / "+limit);
            for(long q = p+1; p+q <= limit; q++) {
                if (Euler.isPerfectSquare(p*p+p*q+q*q)) {
                    if (!map.containsKey(p)) {
                        map.put(p, new ArrayList<Triangle>());
                    }
                    if (!map.containsKey(q)) {
                        map.put(q, new ArrayList<Triangle>());
                    }
                    Triangle tri = new Triangle(p,q);
                    map.get(p).add(tri);
                    map.get(q).add(tri);
                    triangles.add(tri);
                }
            }
        }

        // Finds triangles where sides match
        Set<Long> values = new TreeSet<Long>();
        int i = 0;
        for(Triangle T1 : triangles) {
            if (++i % 1000 == 0)
                System.out.println(i + " / " + triangles.size());

            for(Triangle T2 : map.get(T1.p)) {
                if (T2 == T1)
                    continue;
                for(Triangle T3 : map.get(T1.q)) {
                    if (T3 == T1)
                        continue;
                    Set<Long> nums = new HashSet<Long>(Arrays.asList(T1.p, T1.q, T2.p, T2.q, T3.p, T3.q));
                    int uniques = nums.size();
                    if (uniques == 3) {
                        long sum = 0;
                        for(long num : nums)
                            sum+=num;

                        if (sum <= limit) {
                            values.add(sum);
                        }
                    }
                }
            }
        }

        long sum = 0;
        for(long value : values) {
            sum+=value;
        }
        System.out.println(sum);
    }
}
