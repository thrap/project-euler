package Java;

import utils.Rational;

public class Problem243 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		Rational r = new Rational(1,1);
		int temp = 30;
		int teller = 0;
		for (int tall = 30; true; tall+=temp) {
			teller++;
			if (new Rational(fi(tall),tall).isLessThan(r) || !(new Rational(fi(tall),tall).isLessThan(r) || r.isLessThan(new Rational(fi(tall),tall)))) {
				if (new Rational(fi(tall),tall).isLessThan(r)) {
					temp = tall;
					System.out.println(tall);
				}
				if (new Rational(fi(tall),tall-1).isLessThan(new Rational(15499,94744))) {
					return (tall);
				}
				r = new Rational(fi(tall),tall);
//				System.out.println(tall + ": " + r.toString());
			}
			if (teller%100000 == 0)
				System.out.println(teller);
		}
	}

	public static int fi(int n) {
		int result = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				result -= result / i;
			while (n % i == 0)
				n /= i;
		}
		if (n > 1)
			result -= result / n;
		return result;
	}
}
