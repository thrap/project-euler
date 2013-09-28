package problems;

public class Problem127 {
	public static void main(String[] args) {
//		System.out.println(Euler.gcd(27, 9));
		int limit = 120000;
		long sum=0;
		
		for (int a = 0; a < limit/2; ++a) {
			for (int b = a+1; true; ++b) {
				int c=a+b;
				if (c>limit)
					break;
				if (gcd(a,b)!=1 || gcd(a,c)!=1 || gcd(b,c)!=1)
					continue;
				if ((long)((long)rad(a)*(long)rad(b)*(long)rad(c)) < (long)c) {
					sum+=c;
				}
			}
			if (a % 10 == 0)
				System.out.println(a);
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
