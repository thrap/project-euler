package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem265 {
	static int N = 5;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println(solution() + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static long solution() {
		Set<String> strings = new HashSet<String>();
		for (int i = 1; i < Math.pow(2, N); i++) {
			String binary = binary(i);
			strings.add(binary);
		}
		String first = binary(0);
		klask(first, strings);
		
		long sum = 0;
		for (String string : asdasd) {
			sum+=Long.valueOf(string, 2);
		}
		return sum;
	}

	static Set<String> asdasd = new HashSet<String>();
	
	public static void klask(String sequence, Set<String> sequences) {
		if (sequence.length() == Math.pow(2, N)+N-1) {
			String first = sequence.substring(0,N-1);
			String last = sequence.substring(sequence.length()-N+1);
			if (first.equals(last)) {
				sequence = sequence.substring(0, (int)Math.pow(2, N));
				asdasd.add(sequence);
			}
		} else {
			String last = sequence.substring(sequence.length()-N+1);
			for (String string : sequences) {
				if (string.substring(0,N-1).equals(last)) {
					Set<String> set = new HashSet<String>(sequences);
					set.remove(string);
					klask(sequence+string.charAt(N-1), set);
				}
			}
		}
	}
	
	public static String binary(int n) {
		String binary = Integer.toBinaryString(n);
		
		String foran = "";
		for (int i = binary.length(); i < N; i++) {
			foran+='0';
		}
		return foran+binary;
	}
}
