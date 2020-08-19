import utils.Euler;

public class Problem504 {
    public static void main(String[] args) {
        int m = 100;
        int count = 0;
        for (int a = 1; a <= m; a++) {
            System.out.println(a);
            for (int b = 1; b <= m; b++) {
                for (int c = 1; c <= m; c++) {
                    for (int d = 1; d <= m; d++) {
                        int v = points(a,b)+points(b,c)+points(c,d)+points(d,a)+a+b+c+d-3;
                        if (Euler.isPerfectSquare(v)) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int points(int a, int b) {
        return ((a-1)*(b-1)-(Euler.gcd(a,b)-1))/2;
    }
}
