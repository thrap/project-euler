package Java;

public class Problem120 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		int supersum = 0;
		for (int a = 3; a<= 1000; ++a) {
			int biggest = 0;
			for(int n = 0; n<(a+a); ++n) {
				int sum = pows(a,n);
				if (sum>biggest)
					biggest = sum;
			}
//			if (a%10 == 0)
//				System.out.println(a);
			supersum += biggest;
		}
//		System.out.println(supersum);
		return supersum;
	}

	static int pows(int a, int n) {
		int sum1 = 1;
		int sum2 = 1;
		for (int i = 0; i<n; ++i) {
			sum1*=(a-1);
			sum1%=(a*a);

			sum2*=(a+1);
			sum2%=(a*a);
		}
		return (sum1+sum2)%(a*a);
	}
}
