package problems;

import utils.Euler;
import utils.T;

public class Problem451 {
    public static void main(String[] args) {
        /**
         * m*m == 1 mod n
         *
         * m*m-1 == 0 mod n
         *
         * m*m - 1 = k*n
         */
        long limit = 100;
        long sum = 0;
        T t = new T();
        for(long m = 2; m < limit; m++) {
            System.out.println(m*m-1);
        }
        System.out.println(sum + " " + t);
    }
}
