package Java;

import utils.T;

public class Problem254 {
    public static void main(String[] args) {
        T t = new T();
        int sum = 0;
        for(int i = 1; i <= 20; i++) {
            sum += sg(i);
        }
        System.out.println(sum + " " + t);
    }

    private static int sg(int i) {
        return s(g(i));
    }

    private static int s(int n) {
        int sum = 0;
        do {
            sum += n%10;
        } while ((n = n/10) != 0);
        return sum;
    }

    private static int g(int i) {
        for (int n = 1; true; n++) {
            if (n % 1000000 == 0)
                System.out.println(n);
            if (sf(n) == i)
                return n;
        }
    }

    private static long sf(int n) {
        return s(f(n));
    }

    private static int[] factorial = new int[10];
    static {
        factorial[0] = 1;
        for (int n = 1; n < 10; n++) {
            factorial[n] = n*factorial[n-1];
        }
    }

    private static int f(int n) {
        int f = 0;
        do {
            f += factorial[n%10];
        } while ((n = n/10) != 0);
        return f;
    }
}
