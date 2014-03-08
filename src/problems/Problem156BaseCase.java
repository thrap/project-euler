package problems;

public class Problem156BaseCase {
	public static void main(String[] args) {
		//for hvert siffer, tell de som er foer og gang med 10
		//0-9: 1
		//0-99: 10*1+10 = 20
		//0-999: 10*20 + 100 = 300
		//0-9999: 10*300 + 1000 = 4000
		//0-99999: ... = 50000
		//0-999999: ... = 600000
		//om foerste digit = digit: count+= tall-foerste digit + 1
		int limit = 809921;
		int count = 0;
		for (int i = 0; i <= limit; i++) {
			count += count(i,3);
		}
		System.out.println(count);
		
		System.out.println(f(199981,1));
	}
	
	public static int f(int n, int d) {
		int count = 0;
		for (int i = 0; i <= n; i++) {
			count += count(i,d);
		}
		return count;
	}

	private static int count(int i, int n) {
		int count = 0;
		do {
			if (i % 10 == n)
				count++;
		} while ((i/=10) != 0);
		return count;
	}
}
