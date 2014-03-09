package Java;

import java.util.ArrayList;
import java.util.List;


public class Problem156 {
	
	public static class Interval {
		
		long low;
		long high;
		
		public Interval(long low, long high) {
			this.low = low;
			this.high = high;
		}
		
		public String toString() {
			return "["+low+", "+high+"]";
		}
		
		public boolean isValid() {
			/**
			 * er ikke helt confident paa denna
			 */
			long min = minF(low);
			long max = maxF(high);
			return isSingleDigit() || !(low > max || high < min);
		}
		
		private static final long STEPS = 10;
		
		public List<Interval> split() {
			List<Interval> intervals = new ArrayList<Interval>();
			
			long step = (high+1-low)/STEPS;
			
			for (int i = 0; i < STEPS; i++) {
				intervals.add(new Interval(low+i*step, low+(i+1)*step-1));
			}
			
			
			return intervals;
		}
		
		public boolean isSingleDigit() {
			return high==low;
		}
	}
	
	private static int d;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long supersum = 0;
		for (d = 1; d <= 9; d++) {
			List<Interval> valid = getInitialIntervals();
			
			long sum = 0;
			while (valid.size() != 0) {
				List<Interval> newValids = new ArrayList<Interval>();
				for (Interval interval : valid) {
					if (interval.isSingleDigit()) {
						long n = interval.high;
						if (n == f(n,d))
							sum+=n;
						continue;
					}
					for (Interval smaller : interval.split()) {
						if (smaller.isValid())
							newValids.add(smaller);
					}
				}
				
				valid = newValids;
			}
			
			System.out.println(d + " = " +sum);
			supersum+=sum;
		}
		System.out.println(supersum + " (" + (System.currentTimeMillis()-start)+"ms)");
		
	}
	
	private static List<Interval> getInitialIntervals() {
		List<Interval> valid = new ArrayList<Interval>();
		
		for (int pow = 0; pow < 17; pow++) {
			for (int i = 1; i <= 9; i++) {
				Interval interval = new Interval(i*pow10[pow],(i+1)*pow10[pow] - 1);
				if (interval.isValid()) {
					valid.add(interval);
				}
			}
		}
		
		return valid;
	}

	public static long maxF(long n) {
		
		return f(n,d);
	}
	
	public static long minF(long n) {
		return f(n,d);
	}
	
	private static long f(long n, int d) {
		int[] digits = toDigitArray(n);
		long count = 0;
		for (int pow = digits.length-1; pow >= 1; pow--) {
			long digit = digits[digits.length-pow-1];
			if (digit > d) {
				count += pow10[pow];
			} else if (digit == d) {
				count += n%pow10[pow]+1;
			}
			count += digit*(pow*pow10[pow-1]);
		}
		return count + ((digits[digits.length-1] >= d)?1:0);
	}
	
	private static long[] pow10 = new long[19];
	
	static {
		pow10[0] = 1;
		for (int i = 1; i < pow10.length; i++) {
			pow10[i] = pow10[i-1]*10;
		}
	}
	

	private static int[] toDigitArray(long n) {
		String tall = String.valueOf(n);
		int[] digits = new int[tall.length()];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = tall.charAt(i)-'0';
		}
		return digits;
	}

	public static int firstDigit1(int x) {
		while (x > 9) {
			x /= 10;
		}
		return x;
	}
}
