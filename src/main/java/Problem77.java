import java.util.List;

import utils.Euler;

public class Problem77 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		for (int tallet = 0; tallet <= 100; tallet++) {
			
			List<Integer> list = Euler.primeList(tallet);
			int [] array = new int[tallet+1]; 
			for (int i = 0; i < list.size(); i++) {
				int tall = list.get(i);
				++array[tall];
				for (int j = tall; j < array.length; ++j) {
					array[j]+=array[j-tall];
				}
			}
			if (array[tallet]>5000) {
				return tallet;
			}
//				System.out.println(array[tallet]);
		}
		return 0;
	}
}
