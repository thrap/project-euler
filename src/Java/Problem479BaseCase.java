package Java;

public class Problem479BaseCase {
    public static void main(String[] args) {
        // k*x^3 - x^2*k^2 + x - k^3 = 0

        // im(a) = 0
        // re(b) = re(c)
        // im(b) = -im(c)

        // b+c = re(b)+re(c)+im(b)+im(c) = re(b)+re(c) = 2*re(b)
        // a+b = re(a)+re(b) + im(a)+im(b) = re(a)+re(b)+im(b) = re(a)+re(c)-im(c) = a+^c
        // a+b = a+^c
        // b = ^c
        // ^c = kompleksjonjugat

        //(a+b)^p(a+c)^p(b+c)^p = (a+b)(a+c)(b+c)...(a+b)(a+c)(b+c)

        //(a+b)(a+c) = a^2+ab+ac+bc

        // bc = re(b)^2+im(c)^2
        // ab+ac = a(b+c) = 2*a*re(b)

        // (a+b)(a+c)(b+c) = (a^2+2*a*re(b)+re(b)^2+im(b)^2)*2*re(b)

        System.out.println(S(4));
    }

    private static double S(int n) {
        double sum = 0;
        for (int p = 1; p <= n; p++) {
            for (int k = 1; k <= n; k++) {
                sum += Math.pow(solve(k, -k*k, 1, -k*k*k), p);
            }
        }
        return sum;
    }

    private static double solve(double A, double B, double C, double D) {
        double[] a = new double[2];
        double[] b = new double[2];
        double[] c = new double[2];

        B /= A;
        C /= A;
        D /= A;
        double disc, q, r, s, t, term1;
        q = (3.0*C - (B*B))/9.0;
        r = -(27.0*D) + B*(9.0*C - 2.0*(B*B));
        r /= 54.0;
        disc = q*q*q + r*r;
        a[1] = 0;
        term1 = (B/3.0);

        s = r + Math.sqrt(disc);
        s = ((s < 0) ? -Math.pow(-s, (1.0/3.0)) : Math.pow(s, (1.0/3.0)));
        t = r - Math.sqrt(disc);
        t = ((t < 0) ? -Math.pow(-t, (1.0/3.0)) : Math.pow(t, (1.0/3.0)));
        a[0] = -term1 + s + t;
        term1 += (s + t)/2.0;
        b[0] = c[0] = -term1;
        term1 = Math.sqrt(3.0)*(-t + s)/2;
        b[1] = term1;
        c[1] = -term1;

        return (a[0]*a[0] + a[0]*2*b[0] + b[0]*b[0]+b[1]*b[1])*2*b[0];
    }
}
