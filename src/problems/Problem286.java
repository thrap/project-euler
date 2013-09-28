package problems;

public class Problem286 {
	public static void main(String[] args) {
		recursion("", 0, 50);
	}
	
	static int GOALS = 30;
	static int i = 0;
	
	public static void recursion(String string, int goals, int left) {
		if (left == 0) {
			if (++i % 1000000 == 0)
				System.out.println(string);
		} else if (left + goals >= GOALS) {
			if (left + goals != GOALS) {
				recursion(string+'0', goals, left-1);
			}
			recursion(string+'1', goals+1, left-1);
		}
	}
}
