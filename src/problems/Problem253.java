package problems;

import utils.Euler;
import utils.T;

import java.util.*;

public class Problem253 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        /**
         * Bruke montecarlo kanskje?
         */
        T t = new T();
        Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
        do {
            int M = M(arr);
            count.put(M, count.containsKey(M) ? count.get(M) + 1 : 1);
        } while (Euler.permute(arr, arr.length));

        for(int M : count.keySet()) {
            System.out.println(M + " " + count.get(M));
        }
        System.out.println(t);
    }

    private static class Segment {
        int start;
        int end;
        public Segment(int n) {
            this.start = this.end = n;
        }

        public Segment(Segment a, Segment b) {
            this.start = Math.min(a.start, b.start);
            this.end = Math.max(a.end, b.end);
        }

        public boolean canMerge(Segment s) {
            return (Math.abs(s.end - this.start) == 1) || (Math.abs(s.start - this.end) == 1);
        }


        public String toString() {
            return "["+start+","+end+"]";
        }
    }

    private static int M(int[] arr) {
        List<Segment> segments = new ArrayList<Segment>();
        int M = 0;
        for (int i = 0; i<arr.length; i++) {
            segments.add(new Segment(arr[i]));
            merge(segments);
            M = Math.max(M, segments.size());
        }
        return M;
    }

    private static void merge(Collection<Segment> segments) {
        for(Segment a : segments) {
            for (Segment b : segments) {
                if (a == b)
                    continue;
                if (a.canMerge(b)) {
                    segments.remove(a);
                    segments.remove(b);
                    segments.add(new Segment(a, b));
                    merge(segments);
                    return;
                }
            }
        }
    }
}
