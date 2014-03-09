package Java;

public class Problem113 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static long solution() {
		long sum=0;
		long s=0;
		long[] f = new long[10];
		long[] f2 = new long[10];
//		s=10;
		long t = 10;
		for (int i = 0; i < f.length; i++) {
			f2[i] = t - i;
		}
		t=0;
		for (int i = 0; i < f2.length; i++) {
			t+=f2[i];
		}
		
		int limit = 1000000;
		
		s=65-10-9;
		for (int siffer = 0; siffer < 100-2; siffer++) {
			f[0]=t;
//			System.out.println(t);
			for (int i = 1; i < f.length; i++) {
//				System.out.print(f[i-1]+"-"+f2[i-1]+"=");
				f[i] = f[i-1] - f2[i-1];
//				System.out.println(f[i]);
			}
			t=0;
			for (int i = 0; i < f2.length; i++) {
				f2[i] = f[i];
				t+=f[i];
			}
			s+=t-1-9;
			if (siffer == 100-3) {
				return (t+s-2);
			}
		}
		return 0;
	}
	public static boolean sti(int n){
		String t=""+n;
		for (int i = 0; i < t.length()-1; i++) {
			if(t.charAt(i)<t.charAt(i+1))
				return false;
		}
		return true;
	}
	public static boolean sy(int n){
		String t=""+n;
		for (int i = 0; i < t.length()-1; i++) {
			if(t.charAt(i)>t.charAt(i+1))
				return false;
		}
		return true;
	}
}
