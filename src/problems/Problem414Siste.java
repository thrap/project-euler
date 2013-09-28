package problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem414Siste {
	
	public static int[] findCb(int[] last, int base) {
		int[] inc = last.clone();
		Arrays.sort(inc);
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}

		for (int i = 0; i < 5; i++) {
			if (last[i] != diff[i])
				break;
			if (i == 4) {
				return diff;
			}
		}
		return findCb(diff,base);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
				
		BigInteger supertot = BigInteger.ZERO;
		for (int k = 2; k <= 300; k++) {
			int base = 6*k+3;
			
			Problem414SE_HER.base = base;
			Problem414SE_HER.COUNT.clear();
			Problem414SE_HER.Cb = Problem414SE_HER.findCb(new int[] {0,0,0,0,1});
			for (int i = 0; i < 5; i++) {
				Problem414SE_HER.pow[i] = (long) Math.pow(base, i);
			}
			
			long tot = 0;
			
			/**
			 * [x,x,x,x,i-1]
			 * 
			 * denne er litt retard xD se metode under
			 */
			//de f¿rste (base) sifferene
			long[] perms = new long[base];
			for (long i = 2; (i-1) < base; i++) {
				long number = ((2*base-i)*(i-1))*5;
				perms[(int) (i-1)] = number;
			}
			for (int i = 1; i <= base/2; i++) {
				int[] v1 = decode(i,base);
				tot += perms[2*i-1]*Problem414SE_HER.firstsb(v1);
				
				
				int[] v2 = decode(base-i,base);
				tot += perms[2*i]*Problem414SE_HER.firstsb(v2);
				
			}
			/**
			 * [x,x,x,i,i]
			 */
			//begge siffere like
			for (long i = 1; i < base; i++) {
				long number = 1*(base-i)*(3*i-1)*10;
				tot+=number*Problem414SE_HER.firstsb(decode(i*(base+1),base));
			}
			
			/**
			 * [x,x,x,i,i+n]
			 * for a,a+n: number=2*(base-i)*(4*6*i-(6*n*n-12*n+7))
			 */
			for (int n = 1; n < base; n++) {
				for (long i = n+1; true; i++) {
					long number = 2*(base-i)*(n*6*i-6*n*n-1)*10;
					if (number<=0)
						break;
					tot+=number*Problem414SE_HER.firstsb(decode((i-n)*base+i,base));;
				}
			}
			System.out.println(k + " " + (tot-1));
			supertot = supertot.add(BigInteger.valueOf(tot-1));
		}
		System.out.println(supertot.mod(BigInteger.TEN.pow(18)) + " ("+(System.currentTimeMillis()-start)+"ms)");
	}
	
	public static int[] decode(long number, int base) {
		int[] decoded = new int[5];
		for (int i = 4; i >= 0; i--) {
			long amount = (long) (number/Math.pow(base,i));
			number-=amount*Math.pow(base,i);
			decoded[4-i] = (int)amount;
		}
		return decoded;
	}
	
	public static long code(int[] inc) {
		long res = 0;
		for (int i = 4; i >= 0; i--) {
			res+=inc[i]*pow[i];
		}
		return res;
	}
	
	static Map<Long, Integer> COUNT = new HashMap<Long, Integer>(); 
	
	static long[] pow = new long[5];
	
	public static int sb(int[] inc, int base, int[] Cb) {
		if (inc[0] == Cb[0] && inc[1] == Cb[1] && inc[2] == Cb[2] && inc[3] == Cb[3] && inc[4] == Cb[4])
			return 0;
		Arrays.sort(inc);
		long memo = code(inc);
		if (COUNT.containsKey(memo)) {
			return COUNT.get(memo);
		}
		
		int[] diff = new int[5];
		for (int i = 4; i >= 0; i--) {
			diff[i] += inc[4-i]-inc[i];
			if (diff[i] < 0) {
				diff[i-1]--;
				diff[i] += base;
			}
		}
		int count = 1+sb(diff, base, Cb);
		COUNT.put(memo, count);
		return count;
	}
	
	public static String decodeString(long value, int base) {
		return Arrays.toString(decode(value, base));
	}
}
