package Java;

public class Problem378 {
	public static void main(String[] args) {
		int amount = 1000;
		int[] divisors = new int[amount];
		for (long n = 0; n < amount; n++) {
			divisors[(int) n] = divisorAmount((n*(n+1))/2);
			System.out.println(divisorAmount(divisors[(int)n]));
		}
		
	}
	
	public static int divisorAmount(long numbers) {
		int factors = 1;
		long n = numbers;
		int teller = 0;
		for (int i = 2; i <= n / i; i++) {
			teller = 0;
			while (n % i == 0) {
				// cout<<n<<endl;
				teller++;
				n /= i;
			}
			factors *= (teller + 1);
		}
		if (n > 1)
			factors *= 2;
		return factors;
	}
}
