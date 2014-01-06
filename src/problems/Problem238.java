package problems;

public class Problem238 {
    public static void main(String[] args) {
        long start = 14025256;
        long s = 14025256;
        StringBuilder w = new StringBuilder();
        for (int i = 1; true; i++) {
            w.append(s);
            s = (s*s)%20300713;
            if (s == start) {
                System.out.println("s(n+"+i+") = s(n)");
                break;
            }
        }

        long[] p = new long[(int)Math.pow(10, 3)+1];

        for (int position = 1; position < w.length(); position++) {
            int k = 0;
            if (position > 10000)
                break;
            for(int i = 0; position-1+i < w.length(); i++) {
                k += w.charAt(position-1+i)-'0';
                if (k >= p.length)
                    break;
                if (p[k] == 0)
                    p[k] = position;
            }
        }

        long sum = 0;
        for(int k = 1; k < p.length; k++) {
            sum += p[k];
        }
        System.out.println(sum);
    }
}
