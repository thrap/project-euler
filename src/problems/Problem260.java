package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Problem260 {
	
	public static void main(String[] args) {
		long sum = 0;
		int lim = 100;
		Set<String> winning = new HashSet<String>();
		Set<String> losing = new HashSet<String>();
		for (int x = 0; x <= lim; x++) {
			winning.add(tuple(x,0,0));
			winning.add(tuple(0,x,0));
			winning.add(tuple(0,0,x));
			winning.add(tuple(x,x,0));
			winning.add(tuple(0,x,x));
			winning.add(tuple(x,0,x));
			winning.add(tuple(x,x,x));
		}
		
		LinkedList<String> remaining = new LinkedList<String>();
		for (int x = 0; x <= lim; x++) {
			for (int y = 0; y <= lim; y++) {
				for (int z = 0; z <= lim; z++) {
					if (winning.contains(tuple(x,y,z)) || x == 0 && y == 0 && z == 0)
						continue;
					remaining.add(tuple(x,y,z));
				}
			}
		}

		while(!remaining.isEmpty()) {
			if (remaining.size() % 10000 == 0) {
				System.out.println(remaining.size() + " " + winning.size() + " " + losing.size());
				
				System.out.println(sum(losing));
				System.out.println(173895);
			}
			String el = remaining.poll();
			List<String> list = getChildList(el);
			
			if (winning.containsAll(list)) {
				losing.add(el);
			} else if (containsOne(losing, list)) {
				winning.add(el);
			} else {
				remaining.addLast(el);
			}
		}
		
		for (String string : losing) {
			String[] split = string.split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			int z = Integer.parseInt(split[2]);
			
			if (x <= y && y <= z)
				System.out.println(string);
		}
		System.out.println(sum);
	}

	private static List<String> getChildList(String el) {
		String[] split = el.split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int z = Integer.parseInt(split[2]);
		
		List<String> list = new ArrayList<String>();
		for (int N = 1; N <= x; N++) {
			list.add(tuple(x-N, y, z));
		}
		for (int N = 1; N <= y; N++) {
			list.add(tuple(x, y-N, z));
		}
		for (int N = 1; N <= z; N++) {
			list.add(tuple(x, y, z-N));
		}
		for (int N = 1; N <= Math.min(x, y); N++) {
			list.add(tuple(x-N, y-N, z));
		}
		for (int N = 1; N <= Math.min(x, z); N++) {
			list.add(tuple(x-N, y, z-N));
		}
		for (int N = 1; N <= Math.min(y, z); N++) {
			list.add(tuple(x, y-N, z-N));
		}
		for (int N = 1; N <= Math.min(x, Math.min(y, z)); N++) {
			list.add(tuple(x-N, y-N, z-N));
		}
		return list;
	}

	private static long sum(Set<String> losing) {
		long sum = 0;
		for (String string : losing) {
			String[] split = string.split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			int z = Integer.parseInt(split[2]);
			
			if (x <= y && y <= z)
				sum += x+y+z;
		}
		return sum;
	}

	private static boolean containsOne(Set<String> losing, List<String> list) {
		for (String string : list) {
			if (losing.contains(string))
				return true;
		}
		return false;
	}

	private static String tuple(int x, int y, int z) {
		return x + " " + y + " "+ z;
	}
}
