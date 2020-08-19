import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem185 {
	
	static List<Guess> guesses;
	
	static class Guess implements Comparable<Guess>{
		String value;
		int correct;
		
		public Guess(String value, int correct) {
			this.value = value;
			this.correct = correct;
		}
		
		@Override
		public String toString() {
			return value + ";"+correct+" correct";
		}
		
		@Override
		public int compareTo(Guess o) {
			return correct-o.correct;
		}
	}
	public static void main(String[] args) {
		/*
			90342 ;2 correct
			70794 ;0 correct
			39458 ;2 correct
			34109 ;1 correct
			51545 ;2 correct
			12531 ;1 correct
			
			5616185650518293 ;2 correct
			3847439647293047 ;1 correct
			5855462940810587 ;3 correct
			9742855507068353 ;3 correct
			4296849643607543 ;3 correct
			3174248439465858 ;1 correct
			4513559094146117 ;2 correct
			7890971548908067 ;3 correct
			8157356344118483 ;1 correct
			2615250744386899 ;2 correct
			8690095851526254 ;3 correct
			6375711915077050 ;1 correct
			6913859173121360 ;1 correct
			6442889055042768 ;2 correct
			2321386104303845 ;0 correct
			2326509471271448 ;2 correct
			5251583379644322 ;2 correct
			1748270476758276 ;3 correct
			4895722652190306 ;1 correct
			3041631117224635 ;3 correct
			1841236454324589 ;3 correct
			2659862637316867 ;2 correct
			
		 */
		guesses = new ArrayList<Guess>();
//		guesses.add(new Guess("90342",2));
//		guesses.add(new Guess("70794",0));
//		guesses.add(new Guess("39458",2));
//		guesses.add(new Guess("34109",1));
//		guesses.add(new Guess("51545",2));
//		guesses.add(new Guess("12531",1));
		guesses.add(new Guess("5616185650518293",2));
		guesses.add(new Guess("3847439647293047",1));
		guesses.add(new Guess("5855462940810587",3));
		guesses.add(new Guess("9742855507068353",3));
		guesses.add(new Guess("4296849643607543",3));
		guesses.add(new Guess("3174248439465858",1));
		guesses.add(new Guess("4513559094146117",2));
		guesses.add(new Guess("7890971548908067",3));
		guesses.add(new Guess("8157356344118483",1));
		guesses.add(new Guess("2615250744386899",2));
		guesses.add(new Guess("8690095851526254",3));
		guesses.add(new Guess("6375711915077050",1));
		guesses.add(new Guess("6913859173121360",1));
		guesses.add(new Guess("6442889055042768",2));
		guesses.add(new Guess("2321386104303845",0));
		guesses.add(new Guess("2326509471271448",2));
		guesses.add(new Guess("5251583379644322",2));
		guesses.add(new Guess("1748270476758276",3));
		guesses.add(new Guess("4895722652190306",1));
		guesses.add(new Guess("3041631117224635",3));
		guesses.add(new Guess("1841236454324589",3));
		guesses.add(new Guess("2659862637316867",2));
		Collections.sort(guesses);
		
		Set<Integer>[] choices = new Set[guesses.get(0).value.length()];
		for (int i = 0; i < choices.length; i++) {
			choices[i] = new HashSet<Integer>();
			for (int j = 0; j <= 9; j++) {
				choices[i].add(j);
			}
		}

		List<Set<Integer>[]> list = new ArrayList<Set<Integer>[]>();
		list.add(choices);
		
		for (Guess guess : guesses) {
			System.out.println(guess + " ("+list.size()+")");
			if (guess.correct == 0) {
				for (int i = 0; i < choices.length; i++) {
					choices[i].remove(guess.value.charAt(i)-'0');
					System.out.println(choices[i]);
				}
				choices[0] = new HashSet<Integer>();
				choices[0].add(4);
			} else if (guess.correct == 1) {
				List<Set<Integer>[]> tempList = new ArrayList<Set<Integer>[]>();
				
				for (int i = 0; i < guess.value.length(); i++) {
					int digit = guess.value.charAt(i)-'0';
					
					for (Set<Integer>[] sets : list) {
						if (sets[i].contains(digit)) {
							
							Set<Integer>[] tempChoices = cloneChoices(sets);
							
							tempChoices[i] = new HashSet<Integer>();
							tempChoices[i].add(digit);
							
							//remove others
							for (int j = 0; j < guess.value.length(); j++) {
								if (j != i)
									tempChoices[j].remove(guess.value.charAt(j)-'0');
//								System.out.println(tempChoices[j]);
							}
							if (legalAdd(tempChoices)) {
								tempList.add(tempChoices);
							}
						}
					}
				}
				list = tempList;
			} else if (guess.correct == 2) {
				List<Set<Integer>[]> tempList = new ArrayList<Set<Integer>[]>();
				
				for (int i = 0; i < guess.value.length(); i++) {
					for (int j = i+1; j < guess.value.length(); j++) {
						int digit1 = guess.value.charAt(i)-'0';
						int digit2 = guess.value.charAt(j)-'0';
						
						for (Set<Integer>[] sets : list) {
							if (sets[i].contains(digit1) && sets[j].contains(digit2)) {
								
								Set<Integer>[] tempChoices = cloneChoices(sets);
								
								tempChoices[i] = new HashSet<Integer>();
								tempChoices[i].add(digit1);
								
								tempChoices[j] = new HashSet<Integer>();
								tempChoices[j].add(digit2);
								
								//remove others
								for (int k = 0; k < guess.value.length(); k++) {
									if (k != i && k != j)
										tempChoices[k].remove(guess.value.charAt(k)-'0');
								}
								
								if (legalAdd(tempChoices)) {
//									printChoices(tempChoices);
									tempList.add(tempChoices);
								}
							}
						}
					}
					
				}
				list = tempList;
			} else if (guess.correct == 3) {
				List<Set<Integer>[]> tempList = new ArrayList<Set<Integer>[]>();
				
				for (int i = 0; i < guess.value.length(); i++) {
					for (int j = i+1; j < guess.value.length(); j++) {
						for (int j2 = j+1; j2 < guess.value.length(); j2++) {
							int digit1 = guess.value.charAt(i)-'0';
							int digit2 = guess.value.charAt(j)-'0';
							int digit3 = guess.value.charAt(j2)-'0';
							
							for (Set<Integer>[] sets : list) {
								if (sets[i].contains(digit1) && sets[j].contains(digit2) && sets[j2].contains(digit3)) {
									
									Set<Integer>[] tempChoices = cloneChoices(sets);
									
									tempChoices[i] = new HashSet<Integer>();
									tempChoices[i].add(digit1);
									
									tempChoices[j] = new HashSet<Integer>();
									tempChoices[j].add(digit2);
									
									tempChoices[j2] = new HashSet<Integer>();
									tempChoices[j2].add(digit3);
									
									//remove others
									for (int k = 0; k < guess.value.length(); k++) {
										if (k != i && k != j && k != j2)
											tempChoices[k].remove(guess.value.charAt(k)-'0');
									}
//									printChoices(tempChoices);
									if (legalAdd(tempChoices)) {
										
										tempList.add(tempChoices);
									}
								}
							}
						}
					}
				}
				list = tempList;
			}
		}
		
		for (Set<Integer>[] sets : list) {
			printChoices(sets);
		}
	}
	
	public static boolean legalAdd(Set<Integer>[] choices) {
		for (Guess guess : guesses) {
			int count = 0;
			int count2 = 0;
			for (int i = 0; i < guess.value.length(); i++) {
				if (choices[i].contains(guess.value.charAt(i)-'0'))
					count++;
				if (choices[i].size() == 1 && choices[i].contains(guess.value.charAt(i)-'0'))
					count2++;
			}
			if (count < guess.correct)
				return false;
			if (count2 > guess.correct)
				return false;
		}
		return true;
	}
	public static void printChoices(Set<Integer>[] choices) {
		for (int i = 0; i < choices.length; i++) {
			for (int set : choices[i]) {
				System.out.print(set);
			}
			System.out.print("");
		}
		System.out.println();
	}
	
	public static Set<Integer>[] cloneChoices(Set<Integer>[] sets) {
		Set<Integer>[] result = new Set[sets.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new HashSet<Integer>();
			for (int j : sets[i]) {
				result[i].add(j);
			}
		}
		return result;
	}
}
