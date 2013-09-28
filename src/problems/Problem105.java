package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem105 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}
	
	public static int solution() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:/Python27/Problem105.txt"));
		String line;
		List<int[]> list = new ArrayList<int[]>();
		
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line,",");
			int[] set = new int[st.countTokens()];
			for (int i = 0; i < set.length; i++) {
				set[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(set);
			list.add(set);
//			System.out.println(Arrays.toString(set));
		}
		
		int sum = 0;
		
		for (int[] is : list) {
			if (rule1(is) && rule2(is)){
//				System.out.println(Arrays.toString(is));
				sum+=S(is);
//				list.remove(is);
			}
		}
		return sum;
	}

	public static boolean rule1(int[] array) {
		Set<Integer> values = new HashSet<Integer>();
		for (int a1 = 0; a1 < array.length; a1++) {
			for (int a2 = a1+1; a2 < array.length; a2++) {
				int S = array[a1]+array[a2];
				if (values.contains(S))
					return false;
				values.add(S);
			}
		}
		for (int a1 = 0; a1 < array.length; a1++) {
			for (int a2 = a1+1; a2 < array.length; a2++) {
				for (int a3 = a2+1; a3 < array.length; a3++) {
					int S = array[a1]+array[a2]+array[a3];
					if (values.contains(S))
						return false;
					values.add(S);
				}
			}
		}
		for (int a1 = 0; a1 < array.length; a1++) {
			for (int a2 = a1+1; a2 < array.length; a2++) {
				for (int a3 = a2+1; a3 < array.length; a3++) {
					for (int a4 = a3+1; a4 < array.length; a4++) {
						int S = array[a1]+array[a2]+array[a3]+array[a4];
						if (values.contains(S))
							return false;
						values.add(S);
					}
				}
			}
		}
		for (int a1 = 0; a1 < array.length; a1++) {
			for (int a2 = a1+1; a2 < array.length; a2++) {
				for (int a3 = a2+1; a3 < array.length; a3++) {
					for (int a4 = a3+1; a4 < array.length; a4++) {
						for (int a5 = a4+1; a5 < array.length; a5++) {
							int S = array[a1]+array[a2]+array[a3]+array[a4]+array[a5];
							if (values.contains(S))
								return false;
							values.add(S);
						}
					}
				}
			}
		}
		for (int a1 = 0; a1 < array.length; a1++) {
			for (int a2 = a1+1; a2 < array.length; a2++) {
				for (int a3 = a2+1; a3 < array.length; a3++) {
					for (int a4 = a3+1; a4 < array.length; a4++) {
						for (int a5 = a4+1; a5 < array.length; a5++) {
							for (int a6 = a5+1; a6 < array.length; a6++) {
								int S = array[a1]+array[a2]+array[a3]+array[a4]+array[a5]+array[a6];
								if (values.contains(S))
									return false;
								values.add(S);
							}
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public static int S(int[] s) {
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum+=s[i];
		}
		return sum;
	}
	
	public static boolean rule2(int[] set) {
		//om B inneholder flere enn C skal B > C
		
		int B = set[0];
		int C = 0;
		
		//set er allerede sortert, og algoritmen fungerer da den legger til minste i B og st¿rste i C. (ser at B > C)
		for (int i = 1; i < set.length; i++) {
			B+=set[i];
			C+=set[set.length-i];
			if (B <= C)
				return false;
		}
		return true;
	}
}
