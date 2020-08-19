public class Problem521BaseCase {
    public static void main(String[] args) {
        System.out.println(S(100));
    }

    private static long S(int n) {
        long S = 0;
        boolean[] smpf = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            if (!smpf[i]) {
                for (int j = 1; j*i <= n; j++) {
                    if (!smpf[i*j]) {
                        smpf[i*j] = true;
                        S += i;
                    }
                }
            }
        }
        return S;
    }
}
