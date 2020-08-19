public class Problem135treg {
	public static void main(String[] args) {
		int limit = 1000000;
		int[] array = new int[limit];
		for (long a = 1; a <= limit; a++) {
			if (a%1000 == 0)
				System.out.println(a);
			//(2*a+x)^2 - (a+x)^2 - x^2 < 1000000
			for (long i = 2*a+1; true; i++) {
				long x = i;
				long y = i-a;
				long z = y-a;
				long n = x*x - y*y - z*z;
				if (n<=0) {
					break;
				}
				if (n>=limit)
					continue;
				if (n == 1155)
					System.out.println(x + " " + y + " " +z);
				array[(int)n]++;
			}
		}
		int teller = 0;
		for (int i = 0; i<array.length; ++i) {
			if (array[i]==10) {
				System.out.println(i);
				++teller;
			}
		}
		System.out.println(teller + " " + array[27]);
	}
}
