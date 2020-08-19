import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem44 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		Set<Integer> map = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10000; i++) {
			int asd = (i*(3*i-1))/2;
			map.add(asd);
			list.add(asd);
		}

		for (int i = 0; i < list.size(); i++) {
			int forste = list.get(i);
			for (int j = i; j < list.size(); j++) {
				if (map.contains(forste+list.get(j))) {
					if (map.contains(Math.abs(forste-list.get(j))))
						return (Math.abs(forste-list.get(j)));
				}
				
			}
		}
		return 0;
	}
}
