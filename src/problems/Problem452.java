package problems;

import utils.Euler;
import utils.T;

import java.math.BigInteger;
import java.util.*;

public class Problem452 {

    static int m = 10;
    static int n = 10;
    public static void main(String[] args) {
        T t = new T();
        recurse(1,2, new ArrayList<Integer>());
        System.out.println(count.mod(BigInteger.valueOf(1234567891)) + " " + t);
    }

    private static void recurse(long n, int k, List<Integer> tuple) {
        registerTuple(tuple);
        for(int j = k; n*j <= m; j++) {
            List<Integer> newTuple = new ArrayList<Integer>(tuple);
            if (j == k) {
                newTuple.add(newTuple.size() != 0 ? newTuple.remove(newTuple.size() - 1) + 1 : 1);
            } else {
                newTuple.add(1);
            }

            recurse(n * j, j, newTuple);
        }
    }

    static BigInteger count = BigInteger.ZERO;
    private static void registerTuple(List<Integer> list) {

        int others = 0;
        for(int value : list) {
            others += value;
        }

        BigInteger count = getCount(others);

        for(int value : list) {
            count = count.divide(Euler.factorial(value));
        }

        Problem452.count = Problem452.count.add(count);
    }

    static Map<Integer, BigInteger> memoize = new HashMap<Integer, BigInteger>();
    private static BigInteger getCount(int others) {
        if (memoize.containsKey(others))
            return memoize.get(others);

        BigInteger count = BigInteger.ONE;
        for(int i = n; i > n-others; i--) {
            count = count.multiply(BigInteger.valueOf(i));
        }
        memoize.put(others, count);
        return count;
    }
}
