package problems;

public class Problem451 {
    public static void main(String[] args) {
        System.out.println("l(15) = "+l(15));
        System.out.println("l(100) = "+l(100));
        System.out.println("l(7) = "+l(7));
    }

    private static int l(int n) {
        for(int m = n-2; true; m--) {
            if (m*m % n == 1)
                return m;
        }
    }
}
