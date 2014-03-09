package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Problem271 {
	/**
	 * jaevla mathematica :p
	 * 
	 * n = 13082761331670030;
	 * Reduce[Mod[x^3 , n] == 1 && 1 < x < n, x, Integers]
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/thrap/Dropbox/Project Euler/problem271.txt"));
		
		String line;
		long sum = 0;
		while((line = br.readLine()) != null) {
			String[] split = line.split("x == ");
			for (int i = 1; i < split.length; i++) {
				long n = Long.parseLong(split[i].split(Pattern.quote(" ||"))[0]);
				System.out.println(n);
				sum += n;
				System.out.println(Arrays.toString(split[i].split(Pattern.quote(" ||"))));
			}
		}
		System.out.println(sum);
	}
}
