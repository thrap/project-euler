public class Problem39 {
	public static void main(String[] args) {
		
		System.out.println(solution());
	}

	public static int solution() {
		int[] lool = new int[1000];
		
		for (int i = 1; i <= 1000; i++) {
			for (int j = i; j <= 1000; j++) {
				double asd = i*i + j*j;
				if (Math.sqrt(asd) % 1 == 0) {
					int sum = i + j + (int)Math.sqrt(asd);
					if (sum < 1000) 
						lool[sum]++;
				}
			}
		}
		
		int storste = 0;
		int beste = 0;
		for (int i = 0; i < lool.length; i++) {
			if (storste < lool[i]) {
				storste = lool[i];
				beste = i;
			}
		}
		return beste;
	}
}
