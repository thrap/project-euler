import utils.T;


public class Problem103 {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(solution() + " " + t);
	}

	public static String solution() {
//		int[] A = {11, 17, 20, 22, 23, 24};
//		int[] A1 = {11, 18, 19, 20, 22, 25};
		int[] testSet = {11, 18, 19, 20, 22, 25};
		int[] test = pseudoRule(pseudoRule(pseudoRule(pseudoRule(pseudoRule(testSet)))));
		pseudoRule(test);
//		System.out.println(isSpecialSumSet(test));
//		System.out.println(Arrays.toString(pseudoRule(testSet)));
		return optimumSet(test);
	}

	public static String optimumSet(int[] s) {
		int[] result = new int[s.length+1];
		int pseudoMiddle = (s.length)/2;
		int b = s[pseudoMiddle];
		result[0] = b;
		for (int i = 1; i < result.length; i++) {
			result[i] = result[i-1]+1;
		}
		int best = Integer.MAX_VALUE;
		for (int a1 = 19; a1 < 50; a1++) {
			for (int a2 = a1+1; a2 < 50; a2++) {
				for (int a3 = a2+1; a3 < 50; a3++) {
					for (int a4 = a3+1; a4 < 50; a4++) {
						for (int a5 = a4+1; a5 < 50; a5++) {
							for (int a6 = a5+1; a6 < 50; a6++) {
								for (int a7 = a6+1; a7 < 50; a7++) {
									int[] set = {a1,a2,a3,a4,a5,a6,a7};
									if (isSpecialSumSet(set) && Problem105.S(set) < best) {
										result = set;
										best = Problem105.S(set);
//										System.out.println(Arrays.toString(set));
									} else if (isSpecialSumSet(set)) {
//										System.out.println(Arrays.toString(set));
									}
								}
							}
						}
					}
				}
			}
		}
		String res = "";
		for (int i : result) {
			res+=i;
		}
		return res;
	}
	
	public static int[] pseudoRule(int[] set) {
		int[] result = new int[set.length+1];
		int pseudoMiddle = (set.length)/2;
		int b = set[pseudoMiddle];
//		System.out.println(b);
		result[0] = b;
		for (int i = 1; i < result.length; i++) {
			result[i] = set[i-1]+b;
		}
//		System.out.println(Arrays.toString(result));
		return result;
	}
	
	public static boolean isSpecialSumSet(int[] set) {
		return Problem105.rule1(set) && Problem105.rule2(set);
	}
}
