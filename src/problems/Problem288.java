package problems;

import utils.Euler;
import utils.T;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class Problem288 {

    private static class Sn {
        long last = 290797;

        public long next() {
            long temp = last;
            this.last = (last*last)%50515093;
            return temp;
        }
    }

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
        System.out.println(NF(61,(long)Math.pow(10,7), BigInteger.valueOf(61).pow(10)) + " " + t);
    }

    private static BigInteger NF(int p, long q, BigInteger mod) {
        Tn T = new Tn(p);
        BigInteger nf = BigInteger.ZERO;
        BigInteger P = valueOf(p);
        for (int n = 0; n <= q; n++) {
            if (n % 1000000 == 0)
                System.out.println(n/1000000 +"/"+q/1000000);
            long t = T.next();
            BigInteger modPow = P.modPow(valueOf(n), mod);
            if (modPow.equals(BigInteger.ZERO))
                modPow = modPow.add(mod);
            nf = (nf.add(valueOf(t).multiply((modPow.subtract(BigInteger.ONE)).divide(valueOf(p-1)).mod(mod))));
        }
        return nf.mod(mod);
    }
}
