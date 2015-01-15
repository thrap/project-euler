package Java;

import utils.Euler;
import utils.T;

import java.math.BigInteger;
import java.util.Arrays;

import static java.math.BigInteger.*;

public class Problem467 {
    public static void main(String[] args) {
        T t = new T();
        int N = 10000;
        int[] P = new int[N];
        int[] C = new int[N];

        boolean[] isPrime = Euler.primeArray(1000000);
        int p = 0;
        int c = 0;

        for (int n = 2; p < P.length; n++) {
            if (isPrime[n]) {
                P[p++] = d(n);
            } else if (c < C.length){
                C[c++] = d(n);
            }
        }

        BigInteger[][] S = new BigInteger[P.length+1][P.length+1];
        S[0][0] = ZERO;
        for (int x = 1; x < S.length; x++) {
            S[x][0] = TEN.multiply(S[x-1][0]).add(valueOf(P[x - 1]));
            S[0][x] = TEN.multiply(S[0][x-1]).add(valueOf(C[x-1]));
        }

        for (int x = 1; x < S.length; x++) {
            System.out.println(x);
            for (int y = 1; y < S.length; y++) {
                S[x][y] = TEN.multiply(S[x-1][y]).add(valueOf(P[x-1])).min(TEN.multiply(S[x][y-1]).add(valueOf(C[y-1])));
                if (P[x-1] == C[y-1])
                    S[x][y] = S[x][y].min(TEN.multiply(S[x-1][y-1]).add(valueOf(P[x-1])));
            }
            S[x-1] = null;
        }
        System.out.println(S[S.length-1][S.length-1].mod(valueOf(1000000007)));
        System.out.println(t);

    }

    private static int d(int n) {
        if (n < 10)
            return n;
        int sum = n%10;
        while ((n /= 10) > 0)
            sum += n%10;
        return d(sum);
    }
}

