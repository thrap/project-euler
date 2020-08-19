import java.util.ArrayList;
import java.util.Collections;

public class Problem124 implements Comparable {
	
	private int i;
	private int rad;
	
	public Problem124(int i, int rad) {
		this.i = i;
		this.rad = rad;
	}
	
	public static void main(String[] args) {
		System.out.println(solution());
	}
	
	public static Problem124 solution() {
		ArrayList<Problem124> list = new ArrayList<Problem124>();
		for (int i = 1; i <= 100000; i++) {
			int tall = i;
			int d = 2;
			int sum = 1;
			while (tall > 1) {
				if (tall%d == 0) {
					sum*=d;
					while (tall%d == 0) {
						tall /= d;
					}
				}
				d++;
			}
//			System.out.println(i + " " + sum);
			list.add(new Problem124(i,sum));
		}
		Collections.sort(list);
		return list.get(10000-1);
	}

	@Override
	public int compareTo(Object arg0) {
		return rad-((Problem124) arg0).rad;
	}
	
	public String toString() {
		return (""+ i);
	}
}