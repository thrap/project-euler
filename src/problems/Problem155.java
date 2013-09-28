package problems;

public class Problem155 {
	public static void main(String[] args) {
		int n = 3;
		
		recursion("",0, n);
	}

	private static void recursion(String string, int used, int n) {
		if (used == n) {
			System.out.println(string);
			return;
		}
		for (int i = 2; used+i <= n; i++) {
			recursion(string+" "+i+"P", used+i, n);
		}
		recursion(string+" S", used+1, n);
	}
}
