package Java;

import utils.Euler;
import utils.T;

import static java.math.BigInteger.valueOf;

public class Problem512 {
    public static void main(String[] args) {
        T t = new T();
        int n = 500000000;
        boolean[] isPrime = Euler.primeArray(n);
        long S = 1;
        for (int i = 3; i <= n; i+=2) {
            if ((i+1) % 1000000 == 0)
                System.out.println((i+1)/1000000 + "/500 " + S);
            if (isPrime[i])
                S += i-1;
            else
                S += f(i);
        }
        System.out.println(S + " " + t);
    }

    private static long f(int n) {
        return (Euler.phi(n) * (valueOf(n).modPow(valueOf(n), valueOf(n + 1)).longValue()-1)/(n-1)) % (n+1);
    }
}
