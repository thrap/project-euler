package problems;

import utils.Euler;
import utils.T;

import java.util.ArrayList;
import java.util.List;

public class Problem302 {

    private static long limit = (long)Math.pow(10, 9);
    private static List<Integer> primes = Euler.primeList((int)Math.sqrt(limit/4)+1);
    public static void main(String[] args) {
        T t = new T();
        recurse(1, 0, 0);
        System.out.println(count + " " + t);
    }

    static int count = 0;

    private static void recurse(long n, int index, int primeCount) {

        long p = primes.get(index);
        if (index == primes.size()-1) {
            if (isAchilles(Euler.phi(n)) && isAchilles(n)) {
                System.out.println(n);
                count++;
            }
            return;
        }
        if ((primeCount == 0 && Math.pow(p, 4) >= limit) || (primeCount == 1 && n*p*p >= limit))
            return;

        recurse(n, index+1, primeCount);
        n*=p;
        while ((n = n*p) < limit) {
            recurse(n, index+1, primeCount+1);
        }
    }

    private static boolean isAchilles(long n) {
        List<Integer> values = new ArrayList<Integer>(Euler.primeFactorMap((int) n).values());
        for(int exp : values) {
            if (exp == 1)
                return false;
        }
        return gcd(values, 0) == 1;
    }

    private static int gcd(List<Integer> values, int i) {
        if (i == values.size()-1)
            return values.get(i);
        return Euler.gcd(values.get(i), gcd(values, i + 1));
    }
}
