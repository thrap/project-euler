package problems;

import java.util.ArrayList;

public class Problem31 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		ArrayList<Integer> mynter = new ArrayList<Integer>();
		mynter.add(1);
		mynter.add(2);
		mynter.add(5);
		mynter.add(10);
		mynter.add(20);
		mynter.add(50);
		mynter.add(100);
		mynter.add(200);
		
		int [] array = new int[201]; 
		for (int i = 0; i < mynter.size(); i++) {
			int tall = mynter.get(i);
			++array[tall];
			for (int j = tall; j < array.length; ++j) {
				array[j]+=array[j-tall];
			}
		}
		return array[200];
	}

}
