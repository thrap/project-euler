import utils.Euler;
import utils.T;

import static java.math.BigInteger.valueOf;


public class Problem358 {
    public static void main(String[] args) {
        T t = new T();
        for (long prime : Euler.primeListBetween((99999999999L / 138), 99999999999L / 137 + 11)) {
            if (lastDigits(prime) == 56789L) {
                System.out.println(prime);
                if (isCyclic(prime)) {
                    System.out.println(cyclicSum(prime) + " " + t);
                }
            }
        }
    }

    private static long lastDigits(long p) {
        long lastDigits = 0;
        for (long i = p - 6; i < p - 1; i++) {
            lastDigits = lastDigits * 10 + (10 * (valueOf(10).modPow(valueOf(i), valueOf(p)).longValue())) / p;
        }
        return lastDigits;
    }

    private static long cyclicSum(long p) {
        long sum = 0;
        long r = 1;
        do {
            long x = r * 10;
            sum += x / p;
            r = x % p;
        } while (r != 1);
        return sum;
    }

    private static boolean isCyclic(long p) {
        long count = 0;
        long r = 1;
        do {
            count++;
            long x = r * 10;
            r = x % p;
        } while (r != 1);
        return (count == p - 1);
    }
}
