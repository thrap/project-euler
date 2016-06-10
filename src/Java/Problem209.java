package Java;

import utils.T;

import java.util.HashMap;
import java.util.Map;

public class Problem209 {
    private static int N = 6;
    private static long[] lists = new long[1 << N];
    public static void main(String[] args) {
        T t = old T();
        for (int i = 0; i < (1<<N); i++) {
            int j = (i>>(N-3))&(i>>(N-2))&1^(i>>(N-1))+(((1<<(N-1))-1)&i)*2;
            lists[Math.min(i, j)] |= 1L << Math.max(i, j);
        }
        System.out.println(r(1, 0) + " " + t);
    }
    private static Map<Long, Long> cache = new HashMap<>();
    public static long r(int i, long s) {
        if (i == 1L << N)
            return 1;
        if (cache.containsKey(s))
            return cache.get(s);
        if ((s & 1L<<i) != 0) {
            return r(i+1, s);
        } else {
            long sum = r(i+1, s | (1L << i)) + r(i+1, s | (1L << i) | lists[i]);
            cache.put(s, sum);
            return sum;
        }
    }
}
