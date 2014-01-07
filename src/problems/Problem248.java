package problems;

import utils.Euler;
import utils.T;

import java.util.*;

public class Problem248 {
    public static void main(String[] args) {
        T t = new T();
        recurse(1, Euler.factorial(13).longValue(), new HashSet<Long>(), 0);

        List<Long> numbers = new ArrayList<Long>(set);
        Collections.sort(numbers);
        System.out.println(numbers.get(150000 - 1) + " " + t);
    }

    private static Set<Long> set = new HashSet<Long>();

    private static void recurse(long n, long left, Set<Long> factors, long biggest) {
        if (left == 1)
            set.add(n);
        for(long div : Euler.divisorList(left)) {
            long p = div + 1;
            if (p <= biggest)
                continue;
            if (!factors.contains(p) && Euler.isPrime(p)) {
                int exp = 1;
                do {
                    Set<Long> newFactors = new HashSet<Long>(factors);
                    newFactors.add(p);
                    recurse(n*(long)Math.pow(p, exp++), left/div, newFactors, p);
                } while(left % (div*=p) == 0);
            }
        }
    }
}
