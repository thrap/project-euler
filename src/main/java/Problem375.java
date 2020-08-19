import utils.T;

public class Problem375 {
	private static final int PERIOD = 6308948;
	static long[] S = new long[PERIOD];
	static int[] minLength = new int[PERIOD];
 	private static final long MIN_S = 3;
	
	static {
		S[0] = 25388651;
		
		for (int i = 1; i < S.length; i++) {
			S[i] = (S[i-1]*S[i-1]) % 50515093;
		}
		
		for (int i = 0; i < S.length; i++) {
			long s = S[i];
			for (int j = i+1; true; j++) {
				if (s >= S[j%PERIOD]) {
					minLength[i] = j-i;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		T t = new T();
		System.out.println(M(10000));
		System.out.println(M(2000000000) + " " + t);
		
	}

	private static long M(int N) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (i % 10000000 == 0)
				System.out.println((double)i*100/N + " % ferdig");
			sum += m(N, i);
		}
		return sum;
	}
	
	private static long m(int N, int i) {
		long sum = 0;
		for (int j = i; j <= N; j+=minLength[j%PERIOD]) {
			if(S[j%PERIOD] == MIN_S) {
				return sum + (N-j+1)*MIN_S;
			}
			long length = Math.min(N-j+1, minLength[j%PERIOD]);
			sum += length*S[j%PERIOD];
		}
		return sum;
	}
}
