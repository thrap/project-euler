package Java;

public class Problem78 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
//		for (int tallet = 1; tallet<=100; tallet++) {
		int tallet = 56000;
		long [] array = new long[tallet+1]; 
		for (int i = 1; i < array.length; i++) {
			int tall = i;
			++array[tall];
			for (int j = tall; j < array.length; ++j) {
//					System.out.println(array[j-tall]);
				array[j]+=array[j-tall];
				array[j]%=1000000;
			}
		}
		for (int i = 1; i < array.length; i++) {
			if ((array[i]) % 1000000 == 0)
				return i;
		}
//		System.out.println(array[tallet]+1);
//		if ((array[tallet]+1)%1000 == 0) {
//			System.out.println(tallet);
//		}
//		}
		return 0;
	}
}
