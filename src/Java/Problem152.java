package Java;

public class Problem152 {
	public static void main(String[] args) {
        for (int i = 2; i <= 40; i++) {
            System.out.println(i + ": "+period(i));
        }
        int period = period(7);
        System.out.println(period);
    }

    private static int period(long n) {
        while (n % 2 == 0) n /= 2;
        while (n % 5 == 0) n /= 5;
        if (n == 1) return 0;

        int p = 1;
        for (long k = 10; k % n != 1; p++, k = (k*10) % n);
        return p;
    }
}
