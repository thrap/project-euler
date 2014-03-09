package Java;

public class Problem2 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static int solution() {
		int sum = 0;
		int a = 0;
		int b = 1;
		int c;
		while ((c = a+b) < 4000000) {
			if (c%2==0)
				sum+=c;
			a=b;
			b=c;
		}
		return sum;
	}
}
