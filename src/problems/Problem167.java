package problems;

import java.util.*;

public class Problem167 {

    public static void main(String[] args) {
        /**
         * ER KUN 2 PARTALL PER SEKVENS
         */

        for (int n = 2; n <= 10; n++) {
            List<Integer> Us = Us(2, 2*n+1, 30000);

            System.out.println(Us.get(3+n));

            ytterste:
            for (int offset = 1; offset < Us.size(); offset++) {
                int start = 3+n+1;
                int diff = Us.get(start+offset)-Us.get(start);
                for(int i = start; i+offset < Us.size(); i++) {
                    if (diff != Us.get(i+offset)-Us.get(i)) {
                        break;
                    }
                    if (i +offset == Us.size()-1) {
                        System.out.println(n+": "+offset);
                        System.out.println("Us(n + "+offset+") = Us(n) + "+diff);
                        break ytterste;
                    }
                }
            }
            System.out.println(Us);
        }
    }

    public static List<Integer> Us(int a, int b, int limit) {
        List<Integer> U = new ArrayList<Integer>();
        U.add(a);
        U.add(b);
        Set<Integer> numbers = new HashSet<Integer>(U);
        while(U.size() < limit) {
            int last = U.get(U.size()-1);

            int next;
            for(next = last+(last > 100 ? 2 : 1); true; next+= (last > 100 ? 2 : 1)) {
                int count = 0;
                for (int i = 0; i < U.size(); i++) {
                    int u1 = U.get(i);
                    if (numbers.contains(next-u1)) {
                        count++;
                    }
                }
                if (count == 2) {
                    break;
                }
            }

            U.add(next);
            numbers.add(next);
        }
        return U;
    }
}
