package Java;

import utils.Euler;
import utils.T;

import java.math.BigInteger;
import java.util.*;

public class Problem152 {
    private static int N = 80;
    private static int CACHED_NUMBERS = 23;

    static BigInteger GOAL;
    static BigInteger[] NUMBERS;
    static BigInteger[] MAX_SUM;

    static Set<BigInteger> CACHE = new HashSet<>();

    public static void main(String[] args) {
        T t = new T();
        System.out.println(NUMBERS.length);
        fillCache(BigInteger.ZERO, NUMBERS.length - CACHED_NUMBERS);
        System.out.println("Cache filled " + CACHE.size() + " " +t);
        recc(BigInteger.ZERO, 0);
        System.out.println(count);
    }
    static int count = 0;
    static int calls = 0;
    private static void recc(BigInteger sum, int i) {
        if (sum.equals(GOAL) || CACHE.contains(GOAL.subtract(sum))) {
            count++;
        } else if (!(i == NUMBERS.length - CACHED_NUMBERS || sum.compareTo(GOAL) > 0 || sum.add(MAX_SUM[i]).compareTo(GOAL) < 0)) {
            recc(sum.add(NUMBERS[i]), i+1);
            recc(sum, i+1);
            if (i == 4) {
                System.out.println(++calls + " " + count);
            }
        }
    }

    private static void fillCache(BigInteger sum, int i) {
        if (i == NUMBERS.length) {
            CACHE.add(sum);
        } else {
            fillCache(sum.add(NUMBERS[i]), i + 1);
            fillCache(sum, i + 1);
        }
    }

    static {
        List<Integer> numbers = new ArrayList<>();
        for (int n = 2; n <= N; n++) {
            if (period(n) <= 6 || (period(n) % 3 == 0))
                numbers.add(n);
        }
        BigInteger num = BigInteger.ONE;
        Map<Integer, Integer> factors = new HashMap<>();
        for (int n : numbers) {
            Map<Integer, Integer> numberFactors = Euler.primeFactorMap(n);
            for (Map.Entry<Integer,Integer> factor : numberFactors.entrySet()) {
                if (factors.containsKey(factor.getKey())) {
                    factors.put(factor.getKey(), Math.max(factor.getValue(),factors.get(factor.getKey())));
                } else {
                    factors.put(factor.getKey(), factor.getValue());
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
            num = num.multiply(BigInteger.valueOf(entry.getKey()).pow(entry.getValue()*2));
        }
        GOAL = num.divide(BigInteger.valueOf(2));
        NUMBERS = new BigInteger[numbers.size()];
        MAX_SUM = new BigInteger[numbers.size()];
        for (int i = NUMBERS.length-1; i >= 0; i--) {
            NUMBERS[i] = num.divide(BigInteger.valueOf(numbers.get(i)).pow(2));
            MAX_SUM[i] = (i == NUMBERS.length-1 ? NUMBERS[i] : MAX_SUM[i+1].add(NUMBERS[i]));
        }
    }

    private static int period(long n) {
        while (n % 2 == 0) n /= 2;
        while (n % 5 == 0) n /= 5;
        if (n == 1) return 0;

        int p = 1;
        for (long k = 10; k % n != 1; p++, k = (k*10) % n);
        return p;
    }
}
