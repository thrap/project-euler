package utils;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AllProblems {
	
	public static void main(String[] args) {
		long starten = System.currentTimeMillis();
		Set<Problem> solved = new TreeSet<Problem>();
		Set<Integer> unsolved = new TreeSet<Integer>();
		for (int i = 1; i <= 500; i++) {
			System.out.print("Problem "+i+": ");
			Problem problem = new Problem(i);
			if (problem.isSolved()) {
				solved.add(problem);
			} else {
				unsolved.add(i);
			}
			System.out.println(problem.getSolution());
		}
		
		System.out.println(solved);
		System.out.println(unsolved);
		System.out.println((System.currentTimeMillis()-starten)+"ms totalt paa "+solved.size()+" oppgaver");
		long start = System.currentTimeMillis();
		
		Set<Problem> fastest = new TreeSet<Problem>(Problem.REVERED);
		fastest.addAll(solved);
		int done = 0;
		for (Problem problem : fastest) {
			long atm = System.currentTimeMillis()-start;
			problem.solve();
			++done;
			if (atm > 1000)
				break;
			System.out.println(problem + " " + atm);
		}
		System.out.println(done);
	}
	
	private static class Problem implements Comparable<Problem> {
		
		public static Comparator<Problem> REVERED = new Comparator<Problem>() {

			@Override
			public int compare(Problem arg0, Problem arg1) {
				return arg1.compareTo(arg0);
			}
		};
		private Long time;
		private int number;
		private Object solution;
		
		public Problem(int number) {
			this.number = number;
			solve();
		}
		
		public String toString() {
			return "Problem "+number+": "+(isSolved()?"("+time+"ms)":"UNSOLVED");
		}
		
		public String getSolution() {
			return ""+solution + (isSolved()?" ("+(time)+"ms)":"");
		}

		private void solve() {
			long start = System.currentTimeMillis();
			try {
				Class<?> clazz = Class.forName("Java.Problem"+number);
				Method m = clazz.getMethod("solution");
				solution = m.invoke(null);
				time = System.currentTimeMillis()-start;
			} catch (Exception e) {
				solution = e;
				time = Long.MAX_VALUE;
			}
		}

		@Override
		public int compareTo(Problem arg0) {
			int diff = arg0.time.compareTo(time);
			return diff==0?number-arg0.number:diff;
		}
		
		public boolean isSolved() {
			return !(solution instanceof Exception);
		}
	}
}
