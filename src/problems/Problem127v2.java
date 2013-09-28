package problems;

import java.util.List;

import utils.Euler;

public class Problem127v2 {
	public static void main(String[] args) {
//		System.out.println(Euler.gcd(27, 9));
		int limit = 10000;
		long sum=0;
		for (int a = 2; a < limit; ++a) {
			System.out.println(a);
			List<Integer> list = Euler.primeFactorDistinctList((int)a);
			int aRad = 1;
			for (Integer i : list) 
				aRad*=i;
			for (int b = a+1; true; ++b) {
				int c=a+b;
				if (c>limit)
					break;
				for (int i = 0; i<list.size(); ++i) {
					if (b % list.get(i) == 0 || c % list.get(i) == 0) {
						break;
					} 
					if (i == list.size() -1) {
						if (gcd(b,c)!=1)
							continue;
						if (rad(aRad*b*c) < c) {
							sum+=c;
//							System.out.println(a + " " + b +" " + c);
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
	
	public static int gcd(int a, int b) {
		if (a < 0) {
			a *= -1;
		}
		if (b < 0) {
			b *= -1;
		}
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static int rad(int n) {
		int prod = 1;
		for (int i = 2; i <= n / i; i++) {
			if (n%i == 0) 
				prod*=i;
			while (n % i == 0) {
				// cout<<n<<endl;
				n /= i;
			}
		}
		if (n > 1)
			prod*=n;
		return prod;
	}
}
