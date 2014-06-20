package Java;

import utils.Euler;

public class Problem269 {
    public static void main(String[] args) {
        System.out.println(Z(100000));
    }

    private static long Z(int k) {
        long count = 0;
        for (int n = 1; n <= k; n++) {
            count += (hasIntegerRoot(n) ? 1 : 0);
        }
        return count;
    }

    private static boolean hasIntegerRoot(int n) {
        if (n % 10 == 0)
            return true;
        int[] arr = new int[(int)Math.log10(n)+1];
        for (int i = 0, k = n; k != 0; i++) {
            arr[i] = k % 10;
            k /= 10;
        }
        for(int x : Euler.divisorList(arr[0])) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.pow(-x, i)*arr[i];
            }
            if (sum == 0)
                return true;
        }
        return false;
    }
}
