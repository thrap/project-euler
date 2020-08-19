import utils.Euler;
import utils.T;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Problem409BaseCase {
    static int winning = 0;
    public static void main(String[] args) {
        T t = new T();
        int n = 5;
        recur(n, new HashSet<>());
        System.out.println(winning * Euler.factorial(n).intValue() + " " + t);
    }

    private static void recur(int n, Set<Integer> piles) {
        if (piles.size() == n) {
            if (piles.stream().reduce((x, y) -> x ^ y).get() > 0) {
                winning ++;
            }
        } else {
            Optional<Integer> max = piles.stream().max(Integer::compare);
            for (int i = (max.isPresent() ? max.get() : 1); i < Math.pow(2, n); i++) {
                if (!piles.contains(i)) {
                    Set<Integer> newPiles = new HashSet<>(piles);
                    newPiles.add(i);
                    recur(n, newPiles);
                }
            }
        }
    }
}
