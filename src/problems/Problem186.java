package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.TIntArrayList;

public class Problem186 {
	
	private static class LaggedFibonacciGenerator {
		private int k = 0;
		private int[] S = new int[55];
		
		public int next() {
			k++;
			int number;
			if (k <= 55) {
				number = (int) ((100003L - 200003L*k + 300007L*(long)k*(long)k*(long)k)%modulo);
			} else {
				number = (S[(k-24)%55] + S[(k-55)%55])%modulo;
			}
			
			S[k%55] = number;
			
			
			return number;
		}
	}
	static int modulo = 100;
	private static TIntArrayList[] friends = new TIntArrayList[modulo];
	public static void main(String[] args) {
		LaggedFibonacciGenerator lfg = new LaggedFibonacciGenerator();
		
		int biggest = 0;
		for (int call = 1; true; call++) {
			if (call % 1000 == 0) {
				System.out.println(call + " "+biggest);
			}
			int caller = lfg.next();
			int called = lfg.next();
			
			TIntArrayList callerFriends = friends[caller];
			TIntArrayList calledFriends = friends[called];
			
			if (callerFriends == null && calledFriends == null) {
				TIntArrayList newFriends = new TIntArrayList();
				newFriends.add(caller);
				newFriends.add(called);
				
				friends[caller] = newFriends;
				friends[called] = newFriends;
			} else if (callerFriends != null && calledFriends != null && callerFriends != calledFriends) {
				for (int i = 0; i < calledFriends.size(); i++) {
					int friend = calledFriends.get(i);
					friends[friend] = callerFriends;
					if (callerFriends.contains(friend)) {
						System.out.println(caller);
						System.out.println(called);
						System.out.println(callerFriends);
						System.out.println(calledFriends);
						System.out.println("fuck shut niggu");
						System.exit(0);
					}
					callerFriends.add(friend);
				}
				if (callerFriends.size() > biggest) {
					biggest = callerFriends.size();
				}
			} else if (callerFriends == null) {
				calledFriends.add(caller);
				if (calledFriends.size() > biggest) {
					biggest = calledFriends.size();
				}
				friends[caller] = calledFriends;
			} else if (calledFriends == null) {
				callerFriends.add(caller);
				if (callerFriends.size() > biggest) {
					biggest = callerFriends.size();
				}
				friends[called] = callerFriends;
			} 
			
			if (biggest >= 990) {
				System.out.println(call);
				Set<Integer> set = new HashSet<Integer>();
				for (int i = 0; i < friends[caller].size(); i++) {
					set.add(friends[caller].get(i));
				}
				System.out.println(set.size());
				System.exit(0);
			}
		}
	}
}
