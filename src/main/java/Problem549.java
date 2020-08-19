import utils.Euler;
import utils.T;

import java.util.*;

public class Problem549 {
    public static void main(String[] args) {
        T t = new T();
        int limit = 1000;

        List<Integer> primes = Euler.primeList((int)Math.sqrt(limit)+1);

        System.out.println(primes);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int p : primes) {
            List<Integer> l = new ArrayList<>();
            l.add(0);
            for (int i = 1; Math.pow(p, i) <= limit; i++) {
                int x = Euler.primeFactorMap(i*p).get(p);
                for (int j = 0; j < x; j++) {
                    l.add(p*i);
                }
            }
            map.put(p, l);
        }

        long S = 0;
        for (int i = 2; i <= limit; i++) {
            long max = 0;
            for(Map.Entry<Integer, Integer> ent : Euler.primeFactorMap(i).entrySet()) {
                int b = map.containsKey(ent.getKey()) ? map.get(ent.getKey()).get(ent.getValue()) : ent.getKey();
                if (b >= max) {
                    System.out.println(i + ": " + ent);
                    max = b;
                }
            }
            System.out.println();
            S += max;
        }

//        System.out.println("første" + t);
//
//        List<Integer>[] asd = new List[limit+1];
//        for (int i = 0; i < asd.length; i++) {
//            if (i % 100000 == 0)
//                System.out.println(i);
//            asd[i] = new ArrayList<>();
//        }
//
//        for (int i = 2; i < asd.length; i++) {
//            if (i % 100000 == 0)
//                System.out.println(i);
//            if (asd[i].isEmpty()) {
//                for (int j = 2; i*j < asd.length; j++) {
//                    asd[i].add(i);
//                }
//            }
//        }
//
//        for (int i = 2; i <= limit; i++) {
//            long max = 0;
//            for(int p : asd[i]) {
////                max = Math.max(max, map.containsKey(ent.getKey()) ? map.get(ent.getKey()).get(ent.getValue()) : ent.getKey());
//            }
//            S += max;
//        }

        System.out.println("halla " + S + " " + map.size()+ " " + t);
    }
}
