public class Problem188 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static long solution() {
		long a = 1;
		//1777^^1855
		
		int[] array = new int[1250000];
		for (int i = 0; i < 1250000; i++) {
			a*=1777;
			a%=100000000;

			if (a == 87955697) {
//				System.out.println(i);
			}
			array[i] = (int)a;
		}
		
		int ind = array[1777-1];
		for (int i = 2; i < 1855; i++) {
			--ind;
			ind%=1250000;
			ind = array[ind];
		}
		
		return ind;
	}
	
//	public static long pow(long a, int k, int u) {
//		System.out.println(a + "^" + u);
//		if (k == u-1)
//			return a;
//		long sum = a;
//		for (int i = 0; i < u; i++) {
//			sum*=a;
//		}
//		
//		return pow(sum, k, u+1);
//	}
}
