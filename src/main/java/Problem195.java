import utils.Euler;

public class Problem195 {
    public static void main(String[] args) {
        int count = 0;
        for(long i = 1; i < 100000; i++) {
            for (long j = i+1; j < 1000000; j++) {
                double b = i;
                double c = j;
                double r = Math.sqrt((b*c*(b+c-Math.sqrt(b*b-b*c+c*c)))/(4*(b+c+Math.sqrt(b*b-b*c+c*c))));
                if (r > 100)
                    break;
                if (Euler.isPerfectSquare(i*i+j*j-i*j)) {
                    count++;
                    if (count % 100 == 0) {
                        System.out.println(count);
                        System.out.println((long)b + " " +(long)Math.sqrt(i*i-i*j+j*j)+" "+ (long)c);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
