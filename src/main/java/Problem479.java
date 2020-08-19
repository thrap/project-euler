import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class Problem479 {
    public static void main(String[] args) {
        System.out.println(S(1000000));

    }

    private static long S(int n) {
        BigInteger sum = ZERO;
        BigInteger mod = valueOf(1000000007);
        BigInteger N = valueOf(n);
        for (int k = 1; k <= n; k++) {
            BigInteger K = valueOf(k);
            BigInteger asd = (K.pow(2).subtract(ONE)).multiply(ONE.subtract(K.pow(2)).modPow(N, mod.multiply(K.pow(2))).subtract(ONE));
            sum = sum.add(asd.divide(K.pow(2)));
        }
        return sum.mod(mod).longValue();
    }
}
