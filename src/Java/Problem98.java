package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem98 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		String line = in.readLine();
		StringTokenizer st = new StringTokenizer(line,",");
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		
		ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			int[] character = new int[26];
//			System.out.println(word);
			for (int i = 1; i < word.length()-1; i++) {
				character[word.charAt(i)-'A']++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < character.length; i++) {
				for (int j = 0; j < character[i]; j++) {
					sb.append((char)('A'+i));
				}
			}
			String anagram = sb.toString();
			if (map.containsKey(anagram)) {
				ArrayList temp = map.get(anagram);
				temp.add(word);
				map.put(anagram, temp);
			} else {
				ArrayList list = new ArrayList();
				list.add(word);
				map.put(anagram, list);
			}
//			System.out.println(anagram);
		}
//		System.out.println(map);
		int counter = 0;
		int biggest = 0;
		for (String anagram: map.keySet()) {
			if (map.get(anagram).size() > 1) {
				counter++;
//				if (anagram.length() biggest) {
					biggest=anagram.length();
					System.out.println(anagram + ": "+map.get(anagram));
					anagrams.add(map.get(anagram));
//				}
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for (long i = 1; true; i++) {
			String number = ""+i*i;
			int[] count = new int[10];
			int j; 
			if (number.length() == biggest) {
//				for (j = 0; j < number.length(); j++) {
//					int c = number.charAt(j)-'0';
//					count[c]++;
//					if (count[c] == 2)
//						break;
//				}
//				if (j == number.length()) 
					list.add(""+number);
				
			}
			if (number.length() > biggest+1)
				break;
		}
		
		System.out.println(anagrams);
		System.out.println(anagrams.size());
////		CREATION ->  REACTION
//		for (int i = 0; i < anagrams.size(); i++) {
//			String word1 = anagrams.get(i).get(0);
//			String word2 = anagrams.get(i).get(1);
//			String start = "";
//			String goal = "";
//			for (int j = 1; j < word1.length()-1; j++) {
//				start += word1.charAt(j);
//				goal += word2.charAt(j);
//			}
//			
//			int[] plassering = new int[start.length()];
//			for (int q = 0; q < start.length(); q++) {
//				for (int j = 0; j < start.length(); j++) {
//					if (start.charAt(q) == goal.charAt(j))
//						plassering[q] = j;
//				}
//			}
//			for (int q = 0; q < plassering.length; q++) {
////				System.out.print(plassering[q]);
//			}
////			System.out.println(plassering.length);
//			for (int qa = 0; qa < list.size()-1; qa++) {
//				for (int j = qa+1; j < list.size(); j++) {
//					String number1=list.get(i);
//					String number2=list.get(j);
//					boolean loool = true;
//					for (int aa = 0; aa < plassering.length; aa++) {
//						if (number1.charAt(aa) != number2.charAt(plassering[aa])) {
//							loool = false;
//						}
//					}
//					if (loool) {
//						System.out.println(" " +number1 + "   " + number2);
//						System.out.println(word1 + " "+word2);
//						System.out.println(list.get(i));
//						System.exit(0);
//					}
//				}
//			}
//			System.out.println(start + " " + goal);
//			break;
//		}
		
//		["FORMER", "REFORM"]
//				CDEIRT: ["CREDIT", "DIRECT"]
//				CEENRT: ["CENTRE", "RECENT"]
//				CEEPTX: ["EXCEPT", "EXPECT"]
//				CEORSU: ["COURSE", "SOURCE"]
//				EGINOR: ["IGNORE", "REGION"]
//				ADEGNR: ["DANGER", "GARDEN"]
//		
//		012345678 -> 012345678
//		CREATION ->  REACTION
			
//		System.out.println(map);
		for (int iasddfgas = 0; iasddfgas < anagrams.size(); iasddfgas++) {
			int lol = iasddfgas;
			ArrayList<String> a = anagrams.get(lol);
//			System.out.println(a);
			HashMap<Character, Integer> asd = new HashMap<Character, Integer>();
			for (int i = 1; i < a.get(0).length()-1; i++) {
				if (!asd.containsKey(a.get(0).charAt(i)))
					asd.put(a.get(0).charAt(i), i);
			}
//			System.out.println(asd);
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for (int i = 1; i < a.get(1).length()-1; i++) {
				sb.append(asd.get(a.get(0).charAt(i)));
				sb2.append(asd.get(a.get(1).charAt(i)));
			}
//			System.out.println(sb);
//			System.out.println(sb2);
			
			HashMap<String, String> supersupermap = new HashMap<String, String>();
			supersupermap.put(sb.toString(), sb2.toString());
//			System.out.println(supersupermap);
			int LENGTH = 5;
			
			for (int j = 12; true; j++) {
				String tall = ""+j*j;
				if (tall.length() > LENGTH)
					break;
				if (tall.length() < LENGTH)
					continue;
				HashMap<Character, Integer> hei = new HashMap<Character, Integer>();
				for (int i = 0; i < tall.length(); i++) {
					if (!hei.containsKey(tall.charAt(i)))
						hei.put(tall.charAt(i), i+1);
				}
				StringBuilder sb3 = new StringBuilder();
				for (int i = 0; i < tall.length(); i++) {
					sb3.append(hei.get(tall.charAt(i)));
				}
				String maal = supersupermap.get(sb3.toString());
				if (maal != null) {
					for (int i = 1; true; i++) {
						String tall2 = "" + i*i;
						if (tall2.length() > LENGTH)
							break;
						if (tall2.length() != LENGTH)
							continue;
						StringBuilder sb34 = new StringBuilder();
						for (int ifsd = 0; ifsd < tall2.length(); ifsd++) {
							sb34.append(hei.get(tall2.charAt(ifsd)));
						}
//				System.out.println(sb34);
						if(sb34.toString().equals(maal)) {
//					System.out.println("hei");
							System.out.println(anagrams.get(iasddfgas) + ": "+ tall2 + " " + tall + " = " + i*i);
							break;
						}
					}
				}
//			break;
			}
		}
		
		
		//FORMER = 123453
		//REFORM = 351234
		//FORM = 1234
		//FROM = 1324
		//1296 = 1234
		//9216 = 3214
	}
}
