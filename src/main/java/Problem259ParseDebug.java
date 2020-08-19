import utils.Rational;
import utils.T;

import java.util.*;

public class Problem259ParseDebug {

    private static class R {
        Rational r;
        String s;
        public R(int n) {
            this.r = new Rational(n, 1);
            s = ""+n;
        }

        private R(Rational r, String s) {
            this.r = r;
            this.s = s;
        }

        public R add(R b) {
            return new R(this.r.add(b.r), "("+this.s+")+("+b.s+")");
        }

        public R subtract(R b) {
            return new R(this.r.subtract(b.r), "("+this.s+")-("+b.s+")");
        }

        public R multiply(R b) {
            return new R(this.r.multiply(b.r), "("+this.s+")*("+b.s+")");
        }

        public R divide(R b) {
            return new R(this.r.divide(b.r), "("+this.s+")/("+b.s+")");
        }

        public String toString() {
            return r.toString() + " " + s;
        }
    }

    private static int[] arr = {1, 23, 4, 5, 6, 78, 9};
    public static void main(String[] args) {
        T t = new T();
        for(R r : parse(0, arr.length - 1)) {
            if (r.r.d == 1 && r.r.n > 1)
                System.out.println(r);
        }
        System.out.println(t);
    }

    private static Set<R> parse(int start, int end) {
        if (start == end)
            return new HashSet<R>(Arrays.asList(new R(arr[start])));

        Set<R> ret = new HashSet<R>();

        for (int i = start; i < end; i++) {
            if (start == 0 && end == 6)
                System.out.println(i);
            Set<R> left = parse(start, i);
            Set<R> right = parse(i+1, end);

            for(R a : left) {
                for(R b : right) {
                    ret.add(a.add(b));
                    ret.add(a.subtract(b));
                    ret.add(a.multiply(b));
                    ret.add(a.divide(b));
                }
            }
        }

        return ret;
    }
}
