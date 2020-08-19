public class Problem228 {
	
	public static void main(String[] args) {
		int n = 5;
		
		for (int k = 1; k <= n; k++) {
			double xk = Math.cos((2*k-1)*Math.PI/(2*n));
			double yk = Math.sin((2*k-1)*Math.PI/(2*n));
			
			System.out.println("("+xk + ","+yk+")");
		}
	}
}
