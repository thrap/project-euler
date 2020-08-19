import java.util.Arrays;

public class Problem335BaseCase {
    public static void main(String[] args) {
        System.out.println(M(5));
        System.out.println(M(100));
    }

    private static int M(int x) {
        int[] bowls = new int[x];
        Arrays.fill(bowls, 1);

        int bowl = 0;
        for (int i = 0; true; i++) {
            if (x <= 10)
                System.out.println(Arrays.toString(bowls));

            if (bowls[bowl % x] == x)
                return i+1;
            int lastBowl = bowl % x;
            while (bowls[lastBowl] != 0) {
                bowl++;
                bowls[bowl % x]++;
                bowls[lastBowl]--;
            }
        }
    }
}
