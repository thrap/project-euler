package Java;

public class Problem235 {
	public static void main(String[] args) {
		System.out.println(s(5000));
		System.out.println(solution());
	}
	
	public static double s(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+=u(i);
		}
		return sum;
	}
	
	public static double solution() {
		return r;
	}
	static double r = 1.0023221086328;
	public static double u(int k) {
		
		return (900-3*k)*Math.pow(r, k-1);
	}
}
