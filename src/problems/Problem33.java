package problems;

public class Problem33 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
//		double a = 49;
//		double b = 98;
//		System.out.println(a/b);
//		System.out.println((int)a%10 == (int)b/10);
		
		int teller = 1;
		int nevner = 1;
		for (double i = 10; i <= 99; i+=1) {
			for (double j = 10; j < i; j+=1) {
				if ((int)i/10 == (int)j%10) {
					double b = (int)j/10;
					double a = (int)i%10;
					if (j/i == b/a) {
//						System.out.println(b+" "+a);
						teller*=b;
						nevner*=a;
						
						
					}
				}
			}
		}
		return nevner/teller;
	}
}
