package Java;

public class Problem467BaseCase {
    public static void main(String[] args) {
        int[] P = {2, 3, 5, 7, 2, 4, 8, 1, 5, 2};
        int[] C = {4, 6, 8, 9, 1, 3, 5, 6, 7, 9};

        long[][] S = new long[P.length+1][P.length+1];

        for (int x = 1; x < S.length; x++) {
            S[x][0] = 10*S[x-1][0]+P[x-1];
            S[0][x] = 10*S[0][x-1]+C[x-1];
        }

        for (int x = 1; x < S.length; x++) {
            for (int y = 1; y < S.length; y++) {
                S[x][y] = Math.min(10*S[x-1][y]+P[x-1], 10*S[x][y-1]+C[y-1]);
                if (P[x-1] == C[y-1])
                    S[x][y] = Math.min(S[x][y], 10*S[x-1][y-1]+P[x-1]);
            }
        }
        System.out.println(S[S.length-1][S.length-1]);
        System.out.println(2357246891352679L);
    }
}
