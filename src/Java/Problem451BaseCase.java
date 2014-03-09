package Java;

import utils.T;

public class Problem451BaseCase {
    public static void main(String[] args) {
        System.out.println("l(15) = "+l(15));
        System.out.println("l(100) = "+l(100));
        System.out.println("l(7) = "+l(7));

        T t = new T();
        long sum = 0;
        for(int n = 3; n <= 100; n++) {
            System.out.println(n + ": "+l(n));
            sum+=l(n);
        }
        System.out.println(sum + " " + t);
    }

    private static long l(long n) {
        for(long m = n-2; true; m--) {
            if (m*m % n == 1)
                return m;
        }
    }
}
