public class Problem310BaseCase {
    public static void main(String[] args) {
        int n = 29;
        boolean[][][] hot = new boolean[n+1][n+1][n+1];
        int cold = 0;

        for (int a = 0; a <= n; a++)
            for (int b = 0; b <= n; b++)
                for (int c = 0; c <= n; c++)
                    if (!(hot[a][b][c] = isHot(hot, a, b, c)) && a<=b && b<=c)
                        cold++;

        System.out.println(cold);
    }

    private static boolean isHot(boolean[][][] hot, int a, int b, int c) {
        for (int l = 1; Math.max(a, Math.max(b,c)) >= l*l; l++)
            if ((c-l*l >= 0 && !hot[a][b][c-l*l]) || (a-l*l >= 0 && !hot[a-l*l][b][c]) || (b-l*l >= 0 && !hot[a][b-l*l][c]))
                return true;
        return false;
    }
}
