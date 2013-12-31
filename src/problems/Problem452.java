package problems;

import utils.Euler;
import utils.T;

import java.math.BigInteger;
import java.util.*;

public class Problem452 {

    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static int m = (int)Math.pow(10, 9);
    static int n = m;
    static long mod = 1234567891;

    public static void main(String[] args) {
        T t = new T();

        long sum = 1;
        for(int number = n; number >= 2; number--) {
            if (number % 10000 == 0)
                System.out.println(number);
            sum = (sum + permutations(number)) % mod;
        }
        System.out.println(sum + " " +t);
        System.out.println(count);
    }


    private static Map<String, Long> memoize = new HashMap<String, Long>();
    private static long permutations(int number) {
        List<Integer> factors = new ArrayList<Integer>(Euler.primeFactorMap(number).values());
        Collections.sort(factors);
        Collections.reverse(factors);
        String memo = factors.toString();
        if (memoize.containsKey(memo))
            return memoize.get(memo);

        long perms = permutations(factors, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
        memoize.put(memo, perms);
        return perms;
    }

    private static long permutations(List<Integer> factors, int index, int n, List<Integer> list, List<Integer> combo) {
        if (index == factors.size()) {
            if (n == 1)
                return 0;

            List<Integer> newFactors = new ArrayList<Integer>(factors);
            int left = 0;
            for(int i = 0; i < factors.size(); i++) {
                int newFactor = factors.get(i) - list.get(i);
                newFactors.set(i, newFactor);
                left += newFactor;
            }

            List<Integer> newCombo = new ArrayList<Integer>(combo);
            newCombo.add(n);

            if (left == 0) {
                return permutations(newCombo);
            } else {
                return permutations(newFactors, 0, 1, new ArrayList<Integer>(), newCombo);
            }
        }

        int p = primes[index];

        long sum = 0;
        int pows = factors.get(index);
        for (int pow = 0; pow <= pows && (combo.size() == 0 || n*(int)Math.pow(p, pow) <= combo.get(combo.size()-1)); pow++) {
            List<Integer> l = new ArrayList<Integer>(list);
            l.add(pow);
            sum += permutations(factors, index + 1, n * (int) Math.pow(p, pow), l, combo);
        }
        return sum;
    }

    static Map<String, Integer> count = new HashMap<String, Integer>();

    private static long permutations(List<Integer> combo) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : combo) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        return tuplePermutations(new ArrayList<Integer>(map.values()));
    }

    private static Map<String, Long> tupleMemoize = new HashMap<String, Long>();
    private static long tuplePermutations(List<Integer> tuple) {
        Collections.sort(tuple);
        Collections.reverse(tuple);

        String memo = tuple.toString();

        if (tupleMemoize.containsKey(memo))
            return tupleMemoize.get(memo);

        int others = 0;
        for(int value : tuple) {
            others += value;
        }

        BigInteger count = getCount(others);

        for(int value : tuple) {
            count = count.divide(Euler.factorial(value));
        }

        long perms = count.mod(BigInteger.valueOf(mod)).longValue();
        tupleMemoize.put(memo, perms);
        return perms;
    }

    private static Map<Integer, BigInteger> countMemoize = new HashMap<Integer, BigInteger>();
    private static BigInteger getCount(int others) {
        if (countMemoize.containsKey(others))
            return countMemoize.get(others);

        BigInteger count = BigInteger.ONE;
        for(int i = n; i > n-others; i--) {
            count = count.multiply(BigInteger.valueOf(i));
        }
        countMemoize.put(others, count);
        return count;
    }
}
