import java.util.ArrayList;
import java.util.List;

public class Problem24 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int fact(int i) {
		int prod = 1;
		for (int j = 2; j <= i; j++) {
			prod*=j;
		}
		return prod;
	}
	
	public static String permutation(int number, int i, List<Integer> list) {
		if (list.isEmpty())
			return "";
		int fact = fact(i);
		int index = (number-1)/fact;
		return list.remove(index) + permutation(number-fact*index, i-1, list);
	}
	
	public static String solution() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			list.add(i);
		}
		return permutation(1000000, 9, list);
	}
}
