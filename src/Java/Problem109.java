package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem109 {

	public static class Score implements Comparable<Score> {
		int value;
		int multiplier;

		public Score(int value, int multiplier) {
			this.value = value;
			this.multiplier = multiplier;
		}

		public int value() {
			return value * multiplier;
		}

		public String toString() {
			return "" + value
					+ (multiplier == 1 ? 'S' : (multiplier == 2 ? 'D' : 'T'));
		}

		@Override
		public int compareTo(Score score) {
			return toString().compareTo(score.toString());
		}
	}

	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		Set<Integer> scores = new TreeSet<Integer>();
		for (int score = 1; score <= 20; score++)
			scores.add(score);
		scores.add(25);
//		System.out.println(scores);
		Set<String> checkouts = new TreeSet<String>();
		for (int goal = 2; goal < 100; goal++) {
			Map<Score, List<Score>> three = new HashMap<Score, List<Score>>();
			
			for (Integer score : scores) {
				if (goal < 2 * score)
					break;
				if (goal == 2*score) {
					checkouts.add(new Score(score,2).toString()+": ["+"]");
				} else {
					three.put(new Score(score, 2), new ArrayList<Score>());
				}
			}
//			System.out.println(three);
			
			for (Score first : three.keySet()) {
				for (Integer value : scores) {
					if (first.value() + value > goal)
						break;
					if (first.value() + value == goal) {
						ArrayList<Score> resultat = new ArrayList<Score>();
						resultat.add(new Score(value, 1));
						Collections.sort(resultat);
						checkouts.add(first.toString()+": "+resultat.toString());
					}
					if (first.value() + 2 * value == goal) {
						ArrayList<Score> resultat = new ArrayList<Score>();
						resultat.add(new Score(value, 2));
						Collections.sort(resultat);
						checkouts.add(first.toString()+": "+resultat.toString());
					}
					if (first.value() + 3 * value == goal) {
						List<Score> resultat = new ArrayList<Score>();
						resultat.add(new Score(value, 3));
						Collections.sort(resultat);
						checkouts.add(first.toString()+": "+resultat.toString());
					}
					
					List<Score> list = three.get(first);
					if (first.value() + value < goal)
						list.add(new Score(value, 1));
					if (first.value() + 2 * value < goal)
						list.add(new Score(value, 2));
					if (first.value() + 3 * value < goal)
						list.add(new Score(value, 3));
				}
			}
			
			for (Score first : three.keySet()) {
				for (Score second : three.get(first)) {
					for (int third : scores) {
						int sum = first.value()+second.value();
						for (int multiplier = 1; multiplier <= 3; multiplier++) {
							sum+=third;
							if (sum == goal) {
								List<Score> resultat = new ArrayList<Score>();
								resultat.add(second);
								resultat.add(new Score(third,multiplier));
								Collections.sort(resultat);
								checkouts.add(first.toString()+": "+resultat.toString());
							}
						}
					}
				}
			}
//			System.out.println(three);
//			System.out.println(checkouts.size());
		}
		int sum = 0;
		for (String string : checkouts) {
			if (!string.contains("25T"))
				sum++;
		}
//		System.out.println(sum + " gyldige");
		return sum;
	}
}
