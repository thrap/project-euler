package Java;

import utils.Euler;
import utils.Rational;
import utils.T;

import java.util.*;

public class Problem253 {
    public static void main(String[] args) {
        int pieces = 10;
        int[] arr = new int[pieces];
        for(int i = 0; i<pieces; i++) {
            arr[i] = i+1;
        }

        monteCarlo(Arrays.copyOf(arr, arr.length), 2000000);
        exact(Arrays.copyOf(arr, arr.length));
    }

    private static void monteCarlo(int[] arr, int iterations) {
        T t = new T();
        Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
        for(int i = 0; i < iterations; i++) {
            if (i % (iterations / 100) == 0)
                System.out.println((100*i)/iterations+"/100");
            Euler.shuffle(arr);
            int M = M(arr);
            count.put(M, count.containsKey(M) ? count.get(M) + 1 : 1);
        }

        int total = 0;
        for(int M : count.keySet()) {
            total += M*count.get(M);
        }
        System.out.println("Estimate: "+new Rational(total, iterations).doubleValue() + " " + t);
    }

    private static void exact(int[] arr) {
        T t = new T();
                Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
        do {
            int M = M(arr);
            count.put(M, count.containsKey(M) ? count.get(M) + 1 : 1);
        } while (Euler.permute(arr, arr.length));

        int total = 0;
        for(int M : count.keySet()) {
            System.out.println(M + " " + count.get(M));
            total += M*count.get(M);
        }
        int possibilities = Euler.factorial(arr.length).intValue();
        Rational average = new Rational(total, possibilities);
        System.out.println("Exact: "+average + " = "+average.doubleValue() + " " + t);
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
        for (int piece : arr) {
            segments.add(new Segment(piece));
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
