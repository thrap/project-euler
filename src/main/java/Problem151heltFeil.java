import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem151heltFeil {
	static Random r = new Random();
	static int week = 1000000;
	public static void main(String[] args) {
		for (int weeks = 0; weeks < week; weeks++) {
			if (weeks % 1000000 == 0) 
				System.out.println(weeks);
			List<Integer> envelope = new ArrayList<Integer>();
			envelope.add(1);
			cut(envelope);
			for (int i = 1; i < 15; i++) {
				++days;
				cut(envelope);
			}
		}
		System.out.println(((double)one)/((double)week));
	}
	
	static int days = 0;
	static int one = 0;
	
	private static void cut(List<Integer> envelope) {
		int size = envelope.size();
		int Ai = envelope.remove(new Random().nextInt(size));
		if (size == 1 && Ai != 1) {
			++one;
		}
		while (++Ai <= 5) {
			envelope.add(Ai);
		}
	}
}
