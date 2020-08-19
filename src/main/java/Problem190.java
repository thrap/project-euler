public class Problem190 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static long solution() {
		long sum = 0;
		for (int pm = 2; pm <= 15; pm++) {
			double[] arr = new double[pm];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 1;
			}
			maximize(arr);
//			System.out.println(pm + ": " + Pm(arr));
			sum+=(long)(Pm(arr));
		}
//		System.out.println(sum);
		return sum;
	}

	static double offset = 0.000001;
	
	public static void maximize(double[] arr) {
		offset = 1;
		for (int asd = 0; asd < 5; asd++) {
			offset/=10;
			for (int antall = 0; antall < arr.length; antall++) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (i == j)
							continue;
						double pm = Pm(arr);
						while (pm <= (pm=Pm(change(arr, i, j))));
						arr[i]+=offset;
						arr[j]-=offset;
					}
				}
			}
		}
	}
	
	public static double[] change(double[] arr, int i, int j) {
		arr[i]-=offset;
		arr[j]+=offset;
		return arr;
	}
	
	public static double Pm(double[] arr) {
		double res = 1;
		for (int i = 1; i <= arr.length; i++) {
			res*=Math.pow(arr[i-1], i);
		}
		return res;
	}
}
