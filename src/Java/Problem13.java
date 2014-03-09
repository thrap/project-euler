package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Problem13 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	public static String solution() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem13.txt"));
		BigInteger sum = BigInteger.ZERO;
		String line;
		while ((line = in.readLine())!=null) {
			sum = sum.add(new BigInteger(line));
		}
		return sum.toString().substring(0, 10);
	}
}
