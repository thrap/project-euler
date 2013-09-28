package problems;

public class Problem388 {
	public static void main(String[] args) {
		int N = 1;
		int count = 0;
		for (int a = 0; a <= N; a++) {
			for (int b = 0; b <= N; b++) {
				for (int c = 0; c <= N; c++) {
					if (a == 0 && b == 0 && c == 0)
						continue;
					//lag objekt line kanskje?
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
