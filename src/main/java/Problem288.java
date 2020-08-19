import utils.T;

import java.math.BigInteger;

public class Problem288 {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(NF(61,(long)Math.pow(10,7), BigInteger.valueOf(61).pow(10).longValue()) + " " + t);
    }

    private static long NF(int p, long q, long mod) {
        long NF = 0, pow = 1, S = 290797;
        for (int n = 0; n <= q; n++, pow = (pow * p) % mod, S = (S*S)%50515093) {
            NF = (NF + (S%p)*((pow + (pow == 0 ? mod : 0) - 1)/(p-1))) % mod;
        }
        return NF;
    }
}
