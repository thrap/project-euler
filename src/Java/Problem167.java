package Java;

import utils.T;

import java.util.*;

public class Problem167 {

    public static void main(String[] args) {
        T t = new T();
        long index = (long)Math.pow(10, 11);
        long sum = 0;
        for (int n = 2; n <= 10; n++) {
            List<Integer> Us = Uz(n, 3000000);

            int cycle = getCycle(n, Us);
            int diff = Us.get(n + 4 + cycle) - Us.get(n + 4);

            long count = index/cycle;
            long newIndex = index % cycle;
            if (newIndex < n+4) {
                count--;
                newIndex+=cycle;
            }

            sum += Us.get((int) newIndex-1) + diff * count;
            System.out.println(n + ": Us(n + "+cycle+") = Us(n) + "+diff);
        }
        System.out.println(sum + " " +t);
    }

    private static int getCycle(int n, List<Integer> us) {
        for (int offset = 1; true; offset++) {
            int start = n+4;
            int diff = us.get(start+offset)- us.get(start);
            for(int i = start; i+offset < us.size(); i++) {
                if (diff != us.get(i+offset)- us.get(i)) {
                    break;
                }
                if (i + offset == us.size()-1) {
                    return offset;
                }
            }
        }
    }

    public static List<Integer> Uz(int n, int limit) {
        List<Integer> U = Us(2, 2*n+1, n+5);
        Set<Integer> numbers = new HashSet<Integer>(U);

        while(U.size() < limit) {
            int last = U.get(U.size()-1);

            for(int next = last+2; true; next+=2) {
                if (numbers.contains(next - 2) ^ numbers.contains(next - U.get(n+3))) {
                    U.add(next);
                    numbers.add(next);
                    break;
                }
            }
        }
        return U;
    }

    public static List<Integer> Us(int a, int b, int limit) {
        List<Integer> U = new ArrayList<Integer>();
        U.add(a);
        U.add(b);
        Set<Integer> numbers = new HashSet<Integer>(U);

        while(U.size() < limit) {
            int last = U.get(U.size()-1);

            for(int next = last+1; true; next++) {
                int count = 0;
                for (int u1 : U) {
                    if (numbers.contains(next-u1)) {
                        count++;
                    }
                }
                if (count == 2) {
                    U.add(next);
                    numbers.add(next);
                    break;
                }
            }
        }
        return U;
    }
}
