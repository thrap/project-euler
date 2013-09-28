package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem419 {
	static int[][] C;
	static int[][] count = new int[92][];
	
	/**
	 * se mathematica-filen problem419
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException {
		C = getC();
		print(C);
		
		long[] v = {773188592,111266672,991387859,949388318,86726172,525392886,310366466,283208272,897096936,1008319991,319424747,1022147552,460270689,749066554,1037401417,602153051,614594789,947905090,712653868,69376097,789220520,293339939,314664361,15158499,245098126,336432215,166349857,423962190,10928155,845435999,884550620,428698047,187760166,542057609,817606024,698240251,450698291,252126295,538281634,925860110,422578256,609586868,614841229,1041972259,180178913,188870007,421959861,713658545,551434143,691033003,578710240,248313191,149142813,740900669,107499465,962252372,883465988,1012001270,174734745,180062053,629208191,914369338,60752274,914369338,159206443,915134904,225539634,909298975,183989345,661027524,475813232,276666062,116900653,672548310,526147787,926411071,114671559,585385078,928784252,184955737,1058912838,671643260,476197769,24339116,716960114,795766185,284621494,802001234,953076912,1013347947,929808404,432530296};
		
		long[] counts = new long[3];
		long mod = (long) Math.pow(2, 30);
		for (int i = 0; i < v.length; i++) {
			if (v[i] != 0) {
				long ones = v[i]*count[i][1];
				long twos = v[i]*count[i][2];
				long trees = v[i]*count[i][3];
				
				counts[0] += ones;
				counts[0] %= mod;
				counts[1] += twos;
				counts[1] %= mod;
				counts[2] += trees;
				counts[2] %= mod;
			}
		}
		System.out.println(counts[0]%mod+","+counts[1]%mod+","+counts[2]%mod);
		System.out.println("998567458,1046245404,43363922");
	}

	private static void print(int[][] t) {
		System.out.print("{");
		for (int i = 0; i < t.length; i++) {
			System.out.print("{");
			for (int j = 0; j < t.length; j++) {
				System.out.print(t[i][j]);
				if (j != t.length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("}");
			if (i != t.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	private static int[][] getC() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/thrap/Dropbox/Project Euler/problem419.txt"));
			
			int[][] T = new int[92][92];
			
			int i = 0;
			String line;
			while((line = br.readLine()) != null) {
				count[i] = Problem419BaseCase.count(line.split("\t")[1]);
				List<Integer> evolves = new ArrayList<Integer>();
				for (String string : line.split("\t")[3].split(Pattern.quote(")"))) {
					evolves.add(Integer.parseInt(string.substring(1)));
				}
				
				for (Integer integer : evolves) {
					T[integer-1][i]++;
				}
				System.out.println(i + ": "+ evolves);
				
				i++;
			}

			br.close();
			return T;
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("SHIT NIGGU");
			return null;
		}
	}
}
