package problems;

import utils.T;

import java.math.BigInteger;

public class Problem288 {

    private static class Tn {
        private final int p;
        private long last = 290797;
        public Tn(int p) {
            this.p = p;
        }

        public long next() {
            long temp = last;
            this.last = (last*last)%50515093;
            return temp % p;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        System.out.println(NF(61,(long)Math.pow(10,7), BigInteger.valueOf(61).pow(10).longValue()) + " " + t);
    }

    private static long NF(int p, long q, long mod) {
        Tn T = new Tn(p);
        long NF = 0;
        long modP = 1;
        for (int n = 0; n <= q; n++, modP = (modP * p) % mod) {
            NF = (NF + T.next()*((modP + (modP == 0 ? mod : 0) - 1)/(p-1))) % mod;
        }
        return NF;
    }
}
